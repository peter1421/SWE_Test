
package fcu.sep.fcushop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 註解起來就好了啦.
 *
 *
 *
 *
 *
 */
@RestController
public class TestController {

  @GetMapping("/greeting")
  public String sayHello(@RequestParam String name) {
    return "Hello " + name;
  }

  @GetMapping("/api/cookie1")
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    //創建cookie
    Cookie cookie = new Cookie("name", "zhangsan");
    resp.addCookie(cookie);
    //return "ok";
  }
}
