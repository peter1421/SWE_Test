package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.Account;
import fcu.sep.fcushop.model.BuyerOrder;
import fcu.sep.fcushop.model.FullOrder;
import fcu.sep.fcushop.model.Order;
import fcu.sep.fcushop.service.AccountService;
import fcu.sep.fcushop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fcu.sep.fcushop.controller.AccountController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

	@PostMapping("/api/getFullOrder")
	@ResponseBody
	public List<FullOrder> getOrderData(@RequestParam String email) {
		System.out.println("取得" + email + "訂單詳細資料");
		return orderManager.getFullOrder(email);
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
	public Order addOrder(@RequestParam int orderId, @RequestParam String buyerEmail, @RequestParam int count, @RequestParam String password) {
		System.out.println("orderId is " + orderId);
		System.out.println("buyerEmail is " + buyerEmail);
		System.out.println("password is " + password);
		System.out.println("count is " + count);
		//檢查訂單合理?()

		Account account = new Account(buyerEmail, password);
		Order order = new Order(orderId, buyerEmail, count, "下單中");

		if (!accountController.checkAccount(account)) {
			System.out.println("帳號錯誤");
			return null;
		}
		orderManager.addOrder(order);
		return order;
	}

	@PostMapping("/api/updataOrder")
	@ResponseBody
	public boolean updataOrder(@RequestParam int orderId, @RequestParam String buyerEmail, @RequestParam int count) {
		System.out.println("orderId is " + orderId);
		System.out.println("buyerEmail is " + buyerEmail);
		System.out.println("count is " + count);
		//檢查訂單合理?()
		Order order = new Order(orderId, buyerEmail, count, "下單中");
		orderManager.updateOrder(order);
		return true;
	}

	public int getMaxBill() {
		return Integer.parseInt(String.valueOf(orderManager.getMaxBill()));
	}

	@PostMapping("/api/checkOrder")
	@ResponseBody
	public boolean checkOrder(@RequestParam int orderId, @RequestParam String state) {
		System.out.println("orderId is " + orderId);
		System.out.println("orderState is " + state);
		//檢查訂單合理?()
		String[] stateArr={"下單中","結帳中","運送中"};
		if(state.equals(stateArr[0])) {
			orderManager.updateOrder(orderId, state, getMaxBill() + 1);
			return true;
		}
		return true;
	}
}