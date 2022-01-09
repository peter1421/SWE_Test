
package fcu.sep.fcushop.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 註解起來就好了啦.
 * Checkstyle 說沒用到的
 * import java.io.IOException;
 * import javax.servlet.ServletException;
 *
 *
 */
@RestController
public class TestController {

  /**
   * 註解起來就好了啦.
   *
   *
   *@param name ...
   *@return tag
   *
   */
  @GetMapping("/greeting")
  public String sayHello(@RequestParam final String name) {
    return "Hello " + name;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param req ...
   *@param resp ...
   *
   *
   */
  @GetMapping("/api/cookie1")
  protected void doPost(final HttpServletRequest req,
                        final HttpServletResponse resp) {
    //創建cookie
    Cookie cookie = new Cookie("name", "zhangsan");
    resp.addCookie(cookie);
    //return "ok";
  }
}
