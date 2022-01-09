package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.*;
import fcu.sep.fcushop.service.AccountService;
import fcu.sep.fcushop.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 註解起來就好了啦.
 *
 *
 *
 *
 *
 */

@RestController
public class OrderController {
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */

  @Autowired
  OrderService orderManager;

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  @Autowired
  AccountService accountManager;

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  @Autowired
  AccountController accountController;

  /**
   * 註解起來就好了啦.
   *
   *
   * @return tag
   *
   *
   */
  @GetMapping("/api/getOrder")
    public List<Order> getAccounts() {
    System.out.println("取得所有訂單");
    return orderManager.getOrder();
  }

  /**
   * 註解起來就好了啦.
   *
   *@param email ...
   *@return tag
   *
   *
   */
  @PostMapping("/api/getFullOrder")
  @ResponseBody
    public List<FullOrder> getOrderData(@RequestParam final String email) {
    System.out.println("取得" + email + "訂單詳細資料");
    return orderManager.getFullOrder(email);
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  @GetMapping("/api/getFullOrder")
    public List<FullOrder> getOrderData() {
    System.out.println("取得所有訂單詳細資料");
    return orderManager.getFullOrder();
  }

  /**
   * 註解起來就好了啦.
   *
   *@param state ...
   *@return tag
   *
   *
   */
  @GetMapping("/api/getFullOrder/{state}")
    public List<FullOrder> getOrderDataStates(
            @PathVariable("state") final String state) {
    System.out.println("取得所有訂單詳細資料");
    return orderManager.getFullOrderStates(state);
  }

  /**
   * 註解起來就好了啦.
   *
   * @param email ...
   * @param state ...
   * @return tag
   */
  @PostMapping("/api/getFullOrder2")
  @ResponseBody
  public List<FullOrder> getOrderData2(@RequestParam final String email,
                                       @RequestParam final String state) {
    System.out.println("取得" + email + "訂單詳細資料");
    System.out.println("取得" + state + "訂單詳細資料");
    return orderManager.getFullOrder(email, state);
  }

  /**
   * 註解起來就好了啦.
   *
   *@param email ...
   *@return tag
   *
   *
   */
  @PostMapping("/api/getBuyerOrder")
  @ResponseBody
    public List<BuyerOrder> getBuyerOrder(@RequestParam final String email) {
    System.out.println("查詢購物清單");
    return orderManager.getBuyerOrder(email);
  }

  /**
   * 註解起來就好了啦.
   *
   *@param productId ...
   *@return tag
   *
   *
   */
  @PostMapping("/api/getSellerOrder")
  @ResponseBody
    public List<BuyerOrder> getSellerOrder(
            @RequestParam final String productId) {
    System.out.println("查詢商品訂單");
    return orderManager.getSellerOrder(productId);
  }

  /**
   * 註解起來就好了啦.
   *
   *@param productId ...
   *@param buyerEmail ...
   *@param count ...
   *@param password ...
   *@return tag
   *
   *
   */

  @PostMapping("/api/order")
  @ResponseBody
  public Order addOrder(@RequestParam final int productId,
                        @RequestParam final String buyerEmail,
                        @RequestParam final int count,
                        @RequestParam final String password) {
    //測試api用
    System.out.println("productId is " + productId);
    System.out.println("buyerEmail is " + buyerEmail);
    System.out.println("password is " + password);
    System.out.println("count is " + count);
    //檢查訂單合理?()

    Account account = new Account(buyerEmail, password);
    Order order = new Order(productId, buyerEmail, count, "下單中", 0);
    if (!accountController.checkAccount(account)) {
      System.out.println("帳號錯誤");
      return null;
    }
    orderManager.addOrder(order);
    return order;
  }

  /**
   * 註解起來就好了啦.
   *
   *@param email ...
   *@param productId ...
   *@return tag
   *
   *
   */

  public boolean getReCount(final String email, final int productId) {
    System.out.println(Integer.parseInt(
            String.valueOf(orderManager.getReCount(email, productId))));
    if (Integer.parseInt(String.valueOf(
            orderManager.getReCount(email, productId))) == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * 註解起來就好了啦.
   *
   *@param productId ...
   *@param buyerEmail ...
   *@param count ...
   *@param state ...
   *@param billId ...
   *
   *@return tag
   *
   */

  @PostMapping("/api/addOrder")
  @ResponseBody
  public boolean addOrder1(@RequestParam final int productId,
                           @RequestParam final String buyerEmail,
                           @RequestParam final int count,
                           @RequestParam final String state,
                           @RequestParam final int billId) {
    if (getReCount(buyerEmail, productId)) {
      Order order = new Order(productId, buyerEmail, count, state, billId);
      orderManager.addOrder(order);
      return true;
    } else {
      return false;
    }
  }
  /**
   * 註解起來就好了啦.
   *
   *@param orderId ...
   *@param buyerEmail ...
   *@param count ...
   *@return tag
   *
   *
   */

  @PostMapping("/api/updataOrder")
  @ResponseBody
  public boolean updataOrder(@RequestParam final int orderId,
                             @RequestParam final String buyerEmail,
                             @RequestParam final int count) {
    System.out.println("orderId is " + orderId);
    System.out.println("buyerEmail is " + buyerEmail);
    System.out.println("count is " + count);
    //檢查訂單合理?()
    Order order = new Order(orderId, buyerEmail, count, stateArr[0], 0);
    orderManager.updateOrder(order);
    return true;
  }

  /**
   * 註解起來就好了啦.
   *
   *@param count ...
   *@param billId ...
   *@return tag
   *
   *
   */
  @PostMapping("/api/updateBill")
  @ResponseBody
  public boolean updateBill(@RequestParam final int count,
                            @RequestParam final int billId) {
    orderManager.updateBill(stateArr[count], billId);
    return true;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  public int getMaxBill() {
    return Integer.parseInt(String.valueOf(orderManager.getMaxBill()));
  }


  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  String[] stateArr = {"下單中", "結帳中", "運送中", "已完成"};
  //之後物件化

  /**
   * 註解起來就好了啦.
   *
   *@param orderId ...
   *@param state ...
   *@return tag
   *
   *
   */

  @PostMapping("/api/checkOrder")
  @ResponseBody
  public boolean checkOrder(@RequestParam final int orderId,
                            @RequestParam final String state) {
    System.out.println("orderId is " + orderId);
    System.out.println("orderState is " + state);
    orderManager.updateOrder(orderId, state, getMaxBill() + 1);
    return true;
  }

  /**
   * 註解起來就好了啦.
   *
   *@param ID ...
   *@return tag
   *
   *
   */

  @PostMapping("/api/deleteOrder")
  @ResponseBody
    public boolean deleteOrder(@RequestParam final int ID) {
    orderManager.deleteOrder(ID);
    return true;
    //有空回來補錯誤偵測
  }

  //有空重構Bill物件關系

  /**
   * 註解起來就好了啦.
   *
   *
   *@param email ...
   *@return tag
   *
   */
  @PostMapping("/api/getBillId")
  @ResponseBody
    public List<Integer> getBillId(@RequestParam final String email) {
    return orderManager.getBillId(email);
  }

  /**
   * 註解起來就好了啦.
   *
   *@param billId ...
   *@return tag
   *
   *
   */
  @PostMapping("/api/getBill")
  @ResponseBody
    public List<Bill> getBill(@RequestParam final int billId) {
    return orderManager.getBill(billId);
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  @GetMapping("/api/getAllBill")
  public List<MemberBill> getAllBill() {
    System.out.println(orderManager.getAllBill());
    return orderManager.getAllBill();
  }

}