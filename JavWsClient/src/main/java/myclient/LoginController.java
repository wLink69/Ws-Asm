package myclient;

import userpackage.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
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
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = service.getUserByName(username);

        if (user != null) {
            if (password.equals(user.getPassword())) {

                Cookie cookie = new Cookie("username", user.getUsername());
                cookie.setMaxAge(60*60); //Store cookie for 1 hour
                resp.addCookie(cookie);

                resp.getWriter().println("Dang nhap thanh cong!");
            } else {
                resp.getWriter().println("Sai mat khau!");
            }
        } else {
            resp.getWriter().println("Sai tai khoan!");
        }
    }
}
