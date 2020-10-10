package Beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class MySessionBean implements SessionScopeBeans, Serializable {
  final long serialVersionUID = 1L;

  @PostConstruct
  void message() {
    System.out.println("QQQ");
  }
}
