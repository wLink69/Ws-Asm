package myclient;

import userpackage.MyService;
import userpackage.MyServiceServiceLocator;
import userpackage.Place;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/place/*")
public class PlaceController extends HttpServlet {
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

        String path = req.getPathInfo();
        String[] pathSplit = path.split("/");
        String action = pathSplit[1];
        int id;
        switch (action) {
            case "create":
                req.getRequestDispatcher("/create.jsp").forward(req, resp);
                break;
            case "update":
                id = Integer.parseInt(pathSplit[2]);
                Place place = service.getPlaceById(id);

                req.setAttribute("place", place);
                req.getRequestDispatcher("/update.jsp").forward(req, resp);
                break;
            case "delete":
                id = Integer.parseInt(pathSplit[2]);
                String result = service.deletePlace(id);
                if (result != null) {
                    resp.sendRedirect(req.getContextPath() + "/places");
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        String[] pathSplit = path.split("/");
        String action = pathSplit[1];
        String result = null;
        switch (action) {
            case "create":
                Place place = new Place();
                place.setName(req.getParameter("name"));
                place.setDistrict(req.getParameter("district"));
                place.setImage(req.getParameter("image"));
                place.setInformation(req.getParameter("information"));

                System.out.println(place.getName());

                result =  service.createPlace(place);
                if (result != null) {
                    resp.sendRedirect(req.getContextPath() + "/places");
                }
                break;
            case "update":
                int id = Integer.parseInt(pathSplit[2]);
                Place uPlace = new Place();
                uPlace.setId(id);
                uPlace.setName(req.getParameter("name"));
                uPlace.setDistrict(req.getParameter("district"));
                uPlace.setImage(req.getParameter("image"));
                uPlace.setInformation(req.getParameter("information"));

                result = service.updatePlace(uPlace);
                System.out.println("re: "+result);
                if (result != null) {
                    resp.sendRedirect(req.getContextPath() + "/places/" + id);
                }
                break;
        }
    }
}
