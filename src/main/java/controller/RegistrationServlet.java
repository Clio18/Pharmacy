package controller;

import service.UserService;
import userInterface.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    public static final String USER_SERVICE = "userService";
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        userService = (UserService) servletContext.getAttribute(USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
        System.out.println("STAR");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String familyName = req.getParameter("familyName");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");

        User client = new User(name,familyName,login,password,email,address,phoneNumber);
        System.out.println(client.toString());
        req.getSession().setAttribute("client", client);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("client");
        userService.save(user);


//        if (client == null) {
//            req.getRequestDispatcher("login.jsp").forward(req, resp);
//        } else {


            //userService.save(client);
            //req.getSession().setAttribute("username", client.getLogin());
            System.out.println(userService.getAll().get(0).toString());
            //req.getSession().setAttribute("client", client);
            //req.getRequestDispatcher("simple.jsp").forward(req, resp);
        //}

    }
}