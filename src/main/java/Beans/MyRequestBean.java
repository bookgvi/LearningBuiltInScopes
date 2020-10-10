package Beans;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MyRequestBean {
  public void greetings() {
    System.out.print("Hello from MyRequestBean");
  }

  @PreDestroy
  void message() {
    System.out.print("MyRequest bean will be destroyed immediately...");
  }
}
