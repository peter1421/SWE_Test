package fcu.sep.fcushop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FcushopApplication {

  public static void main(String[] args) {

    SpringApplication.run(FcushopApplication.class, args);
    System.out.println("-------------------------------------------");

    System.out.println("http://localhost:8080/");
  }
}
//http://localhost:8080/