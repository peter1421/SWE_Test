package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;

  public ProductService() {

  }

  public List<Product> getProducts() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select 商品ID id, 商品名稱 name, 商品圖片 imageUrl, 商品價格 price, 商品敘述 description"
      + " from 商品資料 ";
      return connection.createQuery(query).executeAndFetch(Product.class);
    }
  }

  public List<Product> getProducts(String keyword) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select 商品ID id, 商品名稱 name, 商品圖片 imageUrl, 商品價格 price, 商品敘述 description"
      + " from 商品資料 where name like :keyword";

      return connection.createQuery(query)
      .addParameter("keyword", "%" + keyword + "%")
      .executeAndFetch(Product.class);
    }
  }
  public Object getProductsCount() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "SELECT COUNT(*)"+" FROM `fcu_shop`.`商品資料`;";
      return connection.createQuery(query).executeScalar();
    }
  }
  public Object getMaxID() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "SELECT max(商品ID)"+" FROM `fcu_shop`.`商品資料`;";
      return connection.createQuery(query).executeScalar();
    }
  }
  public String addProducts(int ID,String NAME,String IMAGE_URL,int PRICE,String DESCRIPTION) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query=String.format("INSERT INTO `fcu_shop`.`商品資料` (`商品ID`, `商品名稱`, `商品圖片`, `商品價格`, `商品敘述`) VALUES (%d,'%s','%s',%d,'%s');", ID,NAME,IMAGE_URL,PRICE,DESCRIPTION);
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "寫入成功";

    } catch (Exception ex)// 除了SQLException以外之錯誤
    {
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }
  public String deleteProducts(int ID) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query=String.format("DELETE FROM `fcu_shop`.`商品資料` WHERE (`商品ID` = '%d');", ID);
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "寫入成功";
    } catch (Exception ex)// 除了SQLException以外之錯誤
    {
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }
  public String updateProducts(int ID,String NAME,String IMAGE_URL,int PRICE,String DESCRIPTION) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query=String.format("UPDATE `fcu_shop`.`商品資料` SET `商品名稱` = '%s', `商品圖片` = '%s', `商品價格` = '%d', `商品敘述` = '%s' WHERE (`商品ID` = '%d'); ", NAME,IMAGE_URL,PRICE,DESCRIPTION,ID);
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "寫入成功";
    } catch (Exception ex)// 除了SQLException以外之錯誤
    {
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }
}

//UPDATE `fcu_shop`.`product` SET `NAME` = '日本新谷酵素', `IMAGE_URL` = 'https://i.imgur.com/4gtlSqT.png', `PRICE` = '66', `DESCRIPTION` = '暗爽！男友誇我瘦下來簡直女神' WHERE (`ID` = '5');