package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.Account;
import fcu.sep.fcushop.model.Member;
import fcu.sep.fcushop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

	@Autowired
	AccountService accountManager;

	@GetMapping("/api/getAccounts")
	public List<Account> getAccounts() {
		System.out.println("取得所有帳密");
		return accountManager.getAccounts();
	}

	//登入相關
	@PostMapping("/api/login")
	@ResponseBody
	//登入檢查
	public Boolean checkAccount(Account account) {
		if (accountManager.checkLogin(account) == null) {
			System.out.println("null");
			return false;
			//錯誤
		}
		System.out.println("sucess");
		return true;

	}

	public Account getLoginData(@RequestParam String email, @RequestParam String password) {
		//接收前端帳密資料
		System.out.println("email is " + email);
		System.out.println("password is " + password);
		Account account = new Account(email, password);
		//檢查帳密正確
		//checkAccount(account);
		if (accountManager.checkLogin(account) == null) {
			System.out.println("null");
			return new Account("null", "null");
			//錯誤
		}
		return account;
		//比對成功
	}


	//註冊帳密

	//後端檢查註冊_function(){
	// if(帳密可用...)
	// return ture
	// }


	//檢查重複_function(){
	//return ture
	// }

	@PostMapping("/api/singup")
	@ResponseBody
	public Account singUp(@RequestParam String email, @RequestParam String password) {
		System.out.println("email is " + email);
		System.out.println("password is " + password);
		//if(後端檢查註冊_function()==ture&&檢查重複_function()==ture).........
		Account account = new Account(email, password);
		//連線資料庫
		accountManager.addAccount(account);
		return account;
	}

	//會員相關
	@GetMapping("/api/getMembers")
	public List<Member> getMembers() {
		return accountManager.getMembers();
	}

	@PostMapping("/api/member")
	@ResponseBody
	public String singUp(@RequestParam String email, @RequestParam String name, @RequestParam String imageUrl, @RequestParam String phoneNumber, @RequestParam String address) {
		System.out.println("email is " + email);
		//if(後端檢查註冊_function()==ture&&檢查重複_function()==ture).........
		Member member = new Member(email,name,imageUrl,phoneNumber,address);
		//連線資料庫
		accountManager.addMember(member);
		return "ok";
	}
}

