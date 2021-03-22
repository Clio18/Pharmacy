package filter;

import service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


import static controller.LoginServlet.USER_SERVICE;

@WebListener
public class InitAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        UserService userService = new UserService();
        //userService.save(new User("A", "AA", "AAA", "AAAA", "@mail", "street", "044"));
        servletContext.setAttribute(USER_SERVICE, userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}