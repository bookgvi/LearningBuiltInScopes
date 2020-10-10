package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Invalidate session servlet", urlPatterns = "/invalidate")
public class InvalidateServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession(false);
    if (session != null) {
      System.out.printf("Invalidated session with id %s%n", session.getId());
      session.invalidate();
    }
    Writer w = resp.getWriter();
    resp.setContentType("text/html");
    w.write("Session closed...");
  }
}
