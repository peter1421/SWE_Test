package fcu.sep.fcushop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 註解起來就好了啦.
 *
 *
 *
 *
 *
 */
@SpringBootApplication
public class FcushopApplication {

  /**
   * 註解起來就好了啦.
   *
   *
   *@param args ...
   *
   *
   */
  public static void main(final String[] args) {

    SpringApplication.run(FcushopApplication.class, args);
    System.out.println("-------------------------------------------");
    System.out.println("5000網頁:http://localhost:5000/");
    System.out.println("重整瀏覽器:chrome://settings/privacy");
    //netstat -ano|findstr 8080/
  }
}
//http://localhost:8080/