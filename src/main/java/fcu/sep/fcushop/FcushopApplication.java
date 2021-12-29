package fcu.sep.fcushop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FcushopApplication {

	public static void main(String[] args) {

		SpringApplication.run(FcushopApplication.class, args);
		System.out.println("-------------------------------------------");

		System.out.println("網頁:http://localhost:8080/");
		System.out.println("重整瀏覽器:chrome://settings/privacy");
		System.out.println("賣家_商品添加:http://localhost:8080/Seller/form-layouts.html");
	}
}
//http://localhost:8080/