package controller;

import service.UserService;
import userInterface.User;
import validation.Alerts;
import validation.UserValidator;
import validation.ValidatorForApp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ValidationServlet", urlPatterns = "/validation")
public class ValidationServlet extends HttpServlet {
    public static final String USER_SERVICE = "userService";
    private UserService userService;
    private ValidatorForApp<User> validator;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        userService = (UserService) servletContext.getAttribute(USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Validation");
        User user = (User) req.getAttribute("client");
        validator = new UserValidator();
        List<Alerts> alerts = validator.validate(user);

        if (alerts.isEmpty()){
            req.getRequestDispatcher("simple.jsp").forward(req, resp);
            userService.save(user);
        }else {
            req.getSession().setAttribute("alerts", alerts);
            req.getRequestDispatcher("alerts.jsp").forward(req, resp);
        }
    }
}
