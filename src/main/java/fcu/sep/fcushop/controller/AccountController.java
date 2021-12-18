package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.Account;
import fcu.sep.fcushop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	//註冊帳密
	@GetMapping("/signUp/{email}/{password}")
	//前端回傳的方法以後要改 會被電
	public boolean addProducts(@PathVariable("email") String email, @PathVariable("password") String password) {
		//try...ca... 待加

		//第二次檢查註冊帳密 檢查註冊_function(){}
		accountManager.addAccount(email,password);

		return true;
	}
	//第二次檢查註冊_function(){
	// return turn
	// }
	//登入帳密_function(@PathVariable("email") String email, @PathVariable("password") String password){
	//
	// }

	//---------較難----------

	//忘記帳密_function(@PathVariable("email") String email){
	// 寄送email?其他辦法?
	// }

	//快速註冊_function(){
	// }
}
