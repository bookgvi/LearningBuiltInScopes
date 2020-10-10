package Servlets;

import Beans.SessionScopeBeans;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

public class SessionServlet extends HttpServlet {
  @Inject
  SessionScopeBeans mySessionBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    mySessionBean.greetings();

    HttpSession session = req.getSession(false);
    if (session == null) {
      session = req.getSession(true);
    }
    System.out.printf("SessionServlet. Session id: %s%n", session.getId());
    Writer w = resp.getWriter();
    resp.setContentType("text/html;");
    w.write("Hello");
  }
}
