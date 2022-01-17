package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.Account;
import fcu.sep.fcushop.model.Member;
import fcu.sep.fcushop.service.AccountService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




/**
 * 註解起來就好了啦.
 * Checkstyle 說沒用到的
 * import fcu.sep.fcushop.model.Product;.
 * import javax.servlet.http.HttpSession;.
 *
 *
 */
@SuppressWarnings("CheckStyle")
@RestController
public class AccountController { @Autowired
AccountService accountManager;

  @SuppressWarnings("checkstyle:RegexpSingleline")
  @GetMapping("/api/getAllAccounts")
public List<Account> getAccounts() {
    System.out.println("取得所有帳密");
    return accountManager.getAccounts();
  }

  //登入相關
  //登入檢查
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  public Boolean checkAccount(Account account) {
    if (accountManager.checkLogin(account) == null) {
      System.out.println("null");
      return false;
      //錯誤
    }
    System.out.println("sucess");
    return true;

  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  @PostMapping("/api/login")
  @ResponseBody
  public boolean getLoginData(@RequestParam String email,
                              @RequestParam String password,
                              HttpServletRequest req,
                              HttpServletResponse resp) throws IOException {
    //接收前端帳密資料
    System.out.println("email is " + email);
    System.out.println("password is " + password);
    Account account = new Account(email, password);

    //檢查帳密正確
    //checkAccount(account);
    if (accountManager.checkLogin(account) == null) {
      System.out.println("null");
      resp.sendRedirect("/login.html");
      return false;
      //錯誤
    } else {
      Cookie cookie = new Cookie("email", email);

      cookie.setPath("/");
      resp.addCookie(cookie);
      resp.sendRedirect("/Successlogin.html");
      //相關說明:https://www.uj5u.com/ruanti/1020.html
      return true;
      //比對成功
    }
  }


  //註冊帳密

  //後端檢查註冊_function(){
  // if(帳密可用...)
  // return ture
  // }

  //檢查重複_function(){
  //return ture
  // }
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  @PostMapping("/api/singup")
  @ResponseBody

  public boolean singUpAll(@RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String name,
                           @RequestParam String imageUrl,
                           @RequestParam String phoneNumber,
                           @RequestParam String address,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
    System.out.println("email is " + email);
    System.out.println("password is " + password);
    //if(後端檢查註冊_function()==ture&&檢查重複_function()==ture).........
    Account account = new Account(email, password);
    Member member = new Member(email, name, imageUrl, phoneNumber, address);
    //連線資料庫
    accountManager.addAccount(account);
    accountManager.addMember(member);
    response.sendRedirect("/index1.html");
    return true;
  }
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */

  @PostMapping("/api/member")
  @ResponseBody
  public boolean singUp(@RequestParam String email,
                        @RequestParam String name,
                        @RequestParam String imageUrl,
                        @RequestParam String phoneNumber,
                        @RequestParam String address) {
    System.out.println("email is " + email);
    //if(後端檢查註冊_function()==ture&&檢查重複_function()==ture).........
    Member member = new Member(email, name, imageUrl, phoneNumber, address);
    //連線資料庫
    accountManager.addMember(member);
    return true;
  }
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */

  @ResponseBody
  public boolean singUp(@RequestParam String email,
                        @RequestParam String password,
                        HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
    System.out.println("email is " + email);
    System.out.println("password is " + password);
    //if(後端檢查註冊_function()==ture&&檢查重複_function()==ture).........
    Account account = new Account(email, password);
    //連線資
    response.sendRedirect("/index1.html");
    accountManager.addAccount(account);
    return true;
  }
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */

  //會員相關
  @GetMapping("/api/getMembers")
  public List<Member> getMembers() {
    return accountManager.getMembers();
  }



  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */

  @PostMapping("/api/searchMember")
  public List<Member> searchMembers(@RequestParam String email) {
    return accountManager.searchMembers(email);
  }

}


