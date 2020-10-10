package Servlets;

import Beans.MyRequestBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request")
public class SimpleRequest extends HttpServlet {
  @Inject
  MyRequestBean myRequestBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    myRequestBean.greetings();
    resp.getWriter().write("Simple request...");
  }
}
