package fcu.sep.fcushop.controller;
import fcu.sep.fcushop.model.Order;
import fcu.sep.fcushop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class OrderController {
	@Autowired
	OrderService orderManager;

	@PostMapping("/order")
	@ResponseBody
	public Order addOrder(@RequestParam int orderId, @RequestParam String buyerEmail,@RequestParam int count) {
		System.out.println("orderId is " +orderId);
		System.out.println("buyerEmail is " +buyerEmail);
		System.out.println("count is " +count);
		//要加檢查功能
		Order order=new Order(orderId,buyerEmail,count);


		orderManager.addOrder(order);

		return  order;

	}

}
