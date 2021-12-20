package fcu.sep.fcushop.controller;
import fcu.sep.fcushop.model.Account;
import fcu.sep.fcushop.model.Order;
import fcu.sep.fcushop.service.AccountService;
import fcu.sep.fcushop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fcu.sep.fcushop.controller.AccountController;

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


	@PostMapping("/api/order")
	@ResponseBody
	public Order addOrder(@RequestParam int orderId, @RequestParam String buyerEmail,@RequestParam int count,@RequestParam String password) {
		System.out.println("orderId is " +orderId);
		System.out.println("buyerEmail is " +buyerEmail);
		System.out.println("password is " +password);
		System.out.println("count is " +count);
		//檢查訂單合理?()

		Account account=new Account(buyerEmail,password);
		Order order=new Order(orderId,buyerEmail,count);

		if(accountController.checkAccount(account)==false){
			System.out.println("帳號錯誤");
			return null;
		}
		orderManager.addOrder(order);
		return  order;
	}
}