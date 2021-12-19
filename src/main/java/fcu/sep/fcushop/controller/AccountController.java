package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.Account;
import fcu.sep.fcushop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

	@Autowired
	AccountService accountManager;

	@GetMapping("/getAccounts")
	public List<Account> getAccounts() {
		System.out.println("取得所有帳密");
		return accountManager.getAccounts();
	}

	//登入相關
	@PostMapping("/login")
	@ResponseBody
	public Account getLoginData(@RequestParam String email, @RequestParam String password){
		//接收前端帳密資料
		System.out.println("email is " +email);
		System.out.println("password is " +password);
		Account account=new Account();
		account.setEmail(email);
		account.setPassword(password);
		//檢查帳密正確

		return account;
	}




	//註冊帳密

	//後端檢查註冊_function(){
	// if(帳密可用...)
	// return ture
	// }


	@PostMapping("/singup")
	@ResponseBody
	public Account singUp(@RequestParam String email, @RequestParam String password) {
		//try...ca...

		//if(後端檢查註冊_function()==ture).........

		//封裝
		Account account=new Account();
		account.setEmail(email);
		account.setPassword(password);

		//連線資料庫
		accountManager.addAccount(account.getEmail(),account.getPassword());

		return account;
	}



	//---------較難----------

	//忘記帳密_function(@PathVariable("email") String email){
	// 寄送email?其他辦法?
	// }

	//快速註冊_function(){
	// }
}
