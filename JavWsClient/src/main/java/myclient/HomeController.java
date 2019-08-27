package myclient;

import userpackage.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController extends HttpServlet {
    private static MyServiceServiceLocator locator = new MyServiceServiceLocator();
    private static MyService service;

    static {
        try {
            if (service == null) {
                service = locator.getMyServicePort();
            }
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getPathInfo();
        if (id != null) {
            String[] idSplit = id.split("/");
            int placeId = Integer.parseInt(idSplit[1]);
            Place place = service.getPlaceById(placeId);
            Comment[] comments = service.getAllCommentByPlaceId(placeId);
            req.setAttribute("place", place);
            req.setAttribute("comments", comments);
            req.getRequestDispatcher("/place-detail.jsp").forward(req, resp);
        }

        Place[] places = service.getAllPlace();
        req.setAttribute("places", places);
        req.getRequestDispatcher("/place.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if (req.getPathInfo() != null && req.getParameter("comment") != null) {
            String[] idSplit = req.getPathInfo().split("/");
            int placeId = Integer.parseInt(idSplit[1]);

            Place place = service.getPlaceById(placeId);

            Cookie[] cookies = req.getCookies();
            String username = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        username = cookie.getValue();
                        break;
                    }
                }
            }

            if (username == null) {
                resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/login"));
                return;
            }
            User user = service.getUserByName(username);

            String commentContent = req.getParameter("comment");
            Comment comment = new Comment();
            comment.setPlace(place);
            comment.setContent(commentContent);
            comment.setUser(user);
            service.createComment(comment);
            resp.sendRedirect(req.getRequestURI());
        }
    }
}
