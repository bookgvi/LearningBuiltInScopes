package Servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;
import java.util.Arrays;

@WebListener
public class Listener implements ServletContextListener {
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext sc = sce.getServletContext();
    ServletRegistration sr = sc.addServlet("SessionServlet", SessionServlet.class);
    Arrays.stream(new String[]{"/session", "/session"}).forEach(sr::addMapping);
  }
}
