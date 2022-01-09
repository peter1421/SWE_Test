package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Account;
import fcu.sep.fcushop.model.Member;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

/**
 * 註解起來就好了啦.
 *
 *
 *
 *
 *
 */
@Service
public class AccountService {
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  @Autowired
  private Sql2oDbHandler sql2oDbHandler;
  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */

  public List<Account> getAccounts() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select 電子郵件 email, 密碼 password"
          + " from 帳密資料";
      return connection.createQuery(query).executeAndFetch(Account.class);
    }
  }
  /**
   * 註解起來就好了啦.
   *
   *@param account ...
   *
   *@return tag
   *
   */

  public String addAccount(final Account account) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("INSERT INTO `fcu_shop`.`帳密資料` "
          + "(`電子郵件`, `密碼`) "
          + "VALUES ('%s','%s');", account.getEmail(), account.getPassword());
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();

      returnMessage = query + "寫入成功";

    } catch (Exception ex) {
      // 除了SQLException以外之錯誤
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }
  /**
   * 註解起來就好了啦.
   *
   *@param account ...
   *
   *@return tag
   *
   */

  public Object checkLogin(final Account account) {
    //檢查登入 陽春版
    System.out.println("checkLogin");

    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query =  String.format("SELECT * FROM fcu_shop.帳密資料 "
          + "WHERE 電子郵件='%s' "
          + "and 密碼='%s';", account.getEmail(), account.getPassword());
      System.out.println(query);
      return connection.createQuery(query).executeScalar();
    }
  }


  //會員相關
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *@return tag
   *
   */

  public List<Member> getMembers() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select 電子郵件 email, 會員名稱 name,會員頭像 imageUrl, "
          + "手機號碼 phoneNumber, 寄送地址 address"
          + " from 會員資料";
      return connection.createQuery(query).executeAndFetch(Member.class);
    }
  }
  /**
   * 註解起來就好了啦.
   *
   *
   *@param member ...
   *@return tag
   *
   */

  public String addMember(final Member member) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("INSERT INTO `fcu_shop`.`會員資料` "
          + "(`電子郵件`, `會員名稱`, `會員頭像`, `手機號碼`, `寄送地址`) "
          + "VALUES ('%s','%s','%s','%s','%s');", member.getEmail(),
          member.getName(),
          member.getImageUrl(),
          member.getPhoneNumber(),
          member.getAddress());
      System.out.println(query);

      connection.createQuery(query, true).executeUpdate().getKey();

      returnMessage = query + "寫入成功";

    } catch (Exception ex) {
      // 除了SQLException以外之錯誤
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param email ...
   *@return tag
   *
   */

  public List<Member> searchMembers(final String email) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query =  String.format("select 電子郵件 email, 會員名稱 name,"
          + "會員頭像 imageUrl, 手機號碼 phoneNumber, 寄送地址 address"
          + " from 會員資料" + " Where 電子郵件='%s';", email);
      System.out.println(query);
      return connection.createQuery(query).executeAndFetch(Member.class);
    }
  }

}
