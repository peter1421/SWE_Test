package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.Product;
import fcu.sep.fcushop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

  @Autowired
  ProductService productManager;

  @GetMapping("/products")
  public List<Product> getProducts() {
    System.out.println("-------------------------------------------");
    System.out.println( productManager.getProducts());
    System.out.println("-------------------------------------------");

    return productManager.getProducts();

  }

  @GetMapping("/products/{keyword}")
  public List<Product> getProducts(@PathVariable("keyword") String keyword) {
    return productManager.getProducts(keyword);
  }


  public int getProductsCount() {
    return Integer.parseInt(String.valueOf(productManager.getProductsCount()));
  }

  public int getMaxID() {
    return Integer.parseInt(String.valueOf(productManager.getMaxID()));
  }

  @GetMapping("/add/{productName}/{productUrl}/{productMoney}/{productDescription}")
  public List<Product> addProducts(@PathVariable("productName") String productName, @PathVariable("productUrl") String productUrl, @PathVariable("productMoney") String productMoney, @PathVariable("productDescription") String productDescription) {
    productManager.addProducts(getMaxID()+1,productName,"https://i.imgur.com/"+productUrl,Integer.parseInt(productMoney),productDescription);
    return productManager.getProducts();
  }
  @GetMapping("update/{ID}/{productName}/{productUrl}/{productMoney}/{productDescription}")
  public List<Product> updateProducts(@PathVariable("ID") int ID, @PathVariable("productName") String productName, @PathVariable("productUrl") String productUrl, @PathVariable("productMoney") String productMoney, @PathVariable("productDescription") String productDescription) {
    productManager.updateProducts(ID,productName,"https://i.imgur.com/"+productUrl,Integer.parseInt(productMoney),productDescription);
    return productManager.getProducts();
  }
  @GetMapping("/delete/{ID}")
  public List<Product> deleteProducts(@PathVariable("ID") int ID) {
    productManager.deleteProducts(ID);
    return productManager.getProducts();
  }
}


