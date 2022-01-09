package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.Product;
import fcu.sep.fcushop.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 註解起來就好了啦.
 *Checkstyle 說沒用到的
 *import fcu.sep.fcushop.model.Account;
 *
 *
 *
 */

@RestController
public class ProductController {
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  @Autowired
    ProductService productManager;

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  @GetMapping("/api/products")
  public List<Product> getProducts() {
    System.out.println("-------------------------------------------");
    System.out.println(productManager.getProducts());
    System.out.println("-------------------------------------------");

    return productManager.getProducts();

  }

  //@GetMapping("/api/products/{keyword}")
  //public List<Product> getProducts(@PathVariable("keyword") String keyword) {
  //return productManager.getProducts(keyword);
  //}
  /**
   * 註解起來就好了啦.
   *
   *@param productClass ...
   *@return tag
   *
   *
   */
  @GetMapping("/api/products/{productClass}")
  public List<Product> getProducts(@PathVariable("productClass")
      final String productClass) {
    return productManager.getProducts(productClass);
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  public int getProductsCount() {
    return Integer.parseInt(String.valueOf(productManager.getProductsCount()));
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  public int getMaxID() {
    return Integer.parseInt(String.valueOf(productManager.getMaxID()));
  }

  /**
   * 註解起來就好了啦.
   *
   *@param productName ...
   *@param productUrl ...
   *@param productMoney ...
   *@param productDescription ...
   *@param productClass ...
   *@return tag
   *
   *
   */
  @GetMapping("/api/add/{productName}"
      +
      "/{productUrl}/{productMoney}/{productDescription}/{productClass}")
  public List<Product> addProducts(@PathVariable("productName")
      final String productName,
                                   @PathVariable("productUrl")
                                   final String productUrl,
                                   @PathVariable("productMoney")
                                   final String productMoney,
                                   @PathVariable("productDescription")
                                   final String productDescription,
                                   @PathVariable("productClass")
                                   final String productClass) {
    Product product = new Product(getMaxID() + 1,
        productName, "https://i.imgur.com/" + productUrl,
        Integer.parseInt(productMoney),
        productDescription, productClass);
    productManager.addProducts(product);
    return productManager.getProducts();
  }

  /**
   * 註解起來就好了啦.
   *
   *@param ID ...
   *@param productName ...
   *@param productUrl ...
   *@param productMoney ...
   *@param productDescription ...
   *@return tag
   *
   *
   */
  @GetMapping("/api/update/{ID}"
      +
      "/{productName}/{productUrl}/{productMoney}/{productDescription}")
    public List<Product> updateProducts(@PathVariable("ID") final int ID,
                                        @PathVariable("productName")
                                        final String productName,
                                        @PathVariable("productUrl")
                                        final String productUrl,
                                        @PathVariable("productMoney")
                                        final String productMoney,
                                        @PathVariable("productDescription")
                                        final String productDescription) {
    productManager.updateProducts(ID, productName,
        "https://i.imgur.com/" + productUrl,
        Integer.parseInt(productMoney), productDescription);
    return productManager.getProducts();
  }

  /**
   * 註解起來就好了啦.
   *
   *@param Id ...
   *@return tag
   *
   *
   */
  @GetMapping("/api/delete/{Id}")
  public List<Product> deleteProducts(@PathVariable("Id") final int Id) {
    productManager.deleteProducts(Id);
    return productManager.getProducts();
  }
}


//ㄐㄐ