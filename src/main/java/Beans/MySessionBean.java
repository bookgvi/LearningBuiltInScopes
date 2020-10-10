package Beans;

import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class MySessionBean implements SessionScopeBeans, Serializable {
  final long serialVersionUID = 1L;

  public void greetings() {
    System.out.print("Hello from MySessionBean");
  }

  @PreDestroy
  void message() {
    System.out.println("MySessionBean will be destroyed immediately...");
  }
}
