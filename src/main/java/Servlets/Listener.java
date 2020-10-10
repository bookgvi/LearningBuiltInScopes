package Servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Arrays;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener {
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext sc = sce.getServletContext();
    ServletRegistration sr = sc.addServlet("SessionServlet", SessionServlet.class);
    Arrays.stream(new String[]{"/session", "/session2"}).forEach(sr::addMapping);
  }

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    System.out.println("-- HttpSessionListener#sessionCreated invoked --");
    HttpSession session = se.getSession();
    System.out.println("session id: " + session.getId());
    System.out.println("session duration: " + session.getMaxInactiveInterval());
    session.setMaxInactiveInterval(10);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    System.out.println("-- HttpSessionListener#sessionDestroyed invoked --");
  }
}
