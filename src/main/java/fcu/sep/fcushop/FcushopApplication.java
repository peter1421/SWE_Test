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
   *
   *
   *
   */
  public static void main(String[] args) {

    SpringApplication.run(FcushopApplication.class, args);
    System.out.println("-------------------------------------------");

    System.out.println("網頁:http://localhost:8080/index.html");
    System.out.println("網頁:http://localhost:8083/");
    System.out.println("重整瀏覽器:chrome://settings/privacy");
    System.out.println("賣家_商品添加:http://localhost:8080/Seller/form-layouts.html");
    System.out.println("買家_商品瀏覽:http://localhost:8080/food_2.html");
    //netstat -ano|findstr 8080
  }
}
//http://localhost:8080/