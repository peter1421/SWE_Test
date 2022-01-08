package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.*;
import fcu.sep.fcushop.service.AccountService;
import fcu.sep.fcushop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
	@Autowired
	OrderService orderManager;
	@Autowired
	AccountService accountManager;
	@Autowired
	AccountController accountController;

	@GetMapping("/api/getOrder")
	public List<Order> getAccounts() {
		System.out.println("取得所有訂單");
		return orderManager.getOrder();
	}

	@GetMapping("/api/getFullOrder")
	public List<FullOrder> getOrderData() {
		System.out.println("取得所有訂單詳細資料");
		return orderManager.getFullOrder();
	}
	@GetMapping("/api/getFullOrder/{state}")
	public List<FullOrder> getOrderDataStates(@PathVariable("state") String state) {
		System.out.println("取得所有訂單詳細資料");
		return orderManager.getFullOrderStates(state);
	}

	@PostMapping("/api/getFullOrder")
	@ResponseBody
	public List<FullOrder> getOrderData(@RequestParam String email) {
		System.out.println("取得" + email + "訂單詳細資料");
		return orderManager.getFullOrder(email);
	}

	@PostMapping("/api/getFullOrder2")
	@ResponseBody
	public List<FullOrder> getOrderData2(@RequestParam String email, @RequestParam String state) {
		System.out.println("取得" + email + "訂單詳細資料");
		System.out.println("取得" + state + "訂單詳細資料");
		return orderManager.getFullOrder(email, state);
	}

	@PostMapping("/api/getBuyerOrder")
	@ResponseBody
	public List<BuyerOrder> getBuyerOrder(@RequestParam String email) {
		System.out.println("查詢購物清單");
		return orderManager.getBuyerOrder(email);
	}

	@PostMapping("/api/getSellerOrder")
	@ResponseBody
	public List<BuyerOrder> getSellerOrder(@RequestParam String productId) {
		System.out.println("查詢商品訂單");
		return orderManager.getSellerOrder(productId);
	}

	@PostMapping("/api/order")
	@ResponseBody
	public Order addOrder(@RequestParam int productId, @RequestParam String buyerEmail, @RequestParam int count, @RequestParam String password) {
		//測試api用
		System.out.println("productId is " + productId);
		System.out.println("buyerEmail is " + buyerEmail);
		System.out.println("password is " + password);
		System.out.println("count is " + count);
		//檢查訂單合理?()

		Account account = new Account(buyerEmail, password);
		Order order = new Order(productId, buyerEmail, count, "下單中",0);

		if (!accountController.checkAccount(account)) {
			System.out.println("帳號錯誤");
			return null;
		}
		orderManager.addOrder(order);
		return order;
	}


	public boolean getReCount( String email, int productId) {
		System.out.println(Integer.parseInt(String.valueOf(orderManager.getReCount(email,productId))));
		if(Integer.parseInt(String.valueOf(orderManager.getReCount(email,productId)))==0){
			return true;
		}else {
			return false;
		}
	}


	@PostMapping("/api/addOrder")
	@ResponseBody
	public boolean addOrder1(@RequestParam int productId, @RequestParam String buyerEmail, @RequestParam int count, @RequestParam String state,@RequestParam int billId) {
			if(getReCount(buyerEmail, productId)){
				Order order = new Order(productId, buyerEmail, count, state,billId);
				orderManager.addOrder(order);
				return true;
			}else {
				return  false;
			}

	}

	@PostMapping("/api/updataOrder")
	@ResponseBody
	public boolean updataOrder(@RequestParam int orderId, @RequestParam String buyerEmail, @RequestParam int count) {
		System.out.println("orderId is " + orderId);
		System.out.println("buyerEmail is " + buyerEmail);
		System.out.println("count is " + count);
		//檢查訂單合理?()
		Order order = new Order(orderId, buyerEmail, count, stateArr[0],0);
		orderManager.updateOrder(order);
		return true;
	}

	public int getMaxBill() {
		return Integer.parseInt(String.valueOf(orderManager.getMaxBill()));
	}




	String[] stateArr = {"下單中", "結帳中","處理中","運送中"};
	//之後物件化

	@PostMapping("/api/checkOrder")
	@ResponseBody
	public boolean checkOrder(@RequestParam int orderId, @RequestParam String state) {
		System.out.println("orderId is " + orderId);
		System.out.println("orderState is " + state);
		orderManager.updateOrder(orderId, state, getMaxBill() + 1);
		return true;
	}

	@PostMapping("/api/deleteOrder")
	@ResponseBody
	public boolean deleteOrder(@RequestParam int ID) {
		orderManager.deleteOrder(ID);
		return true;
		//有空回來補錯誤偵測
	}

	@PostMapping("/api/getBillId")
	@ResponseBody
	public  List<Integer> getBillId(@RequestParam String email) {
		return orderManager.getBillId(email);
	}
	@PostMapping("/api/getBill")
	@ResponseBody
	public  List<Bill> getBill(@RequestParam int billId) {
		return orderManager.getBill(billId);
	}

}