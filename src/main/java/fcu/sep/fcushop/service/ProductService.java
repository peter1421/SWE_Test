package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Product;
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
public class ProductService {

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
   *
   *
   *
   */
  public ProductService() {

  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *@return tag
   *
   */
  public List<Product> getProducts() {
    //取得所有商品資料
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select 商品ID id, 商品名稱 name, 商品圖片 imageUrl, "
          + "商品價格 price, 商品敘述 description"
          + " from 商品資料 ";
      return connection.createQuery(query).executeAndFetch(Product.class);
    }
  }
  /**
   * 註解起來就好了啦.
   *
   *@param productClass ...
   *
   *@return tag
   *
   */

  public List<Product> getProducts(final String productClass) {
    //取得搜尋後商品分類
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("select 商品ID id, 商品名稱 name, "
          + "商品圖片 imageUrl, 商品價格 price, 商品敘述 description"
          + " from 商品資料 where 商品分類='%s'", productClass);
      System.out.println(query);

      return connection.createQuery(query).executeAndFetch(Product.class);
    }
  }

  //  public List<Product> getProducts(String keyword) {
  //    //取得搜尋後商品數量
  //    try (Connection connection = sql2oDbHandler.getConnector().open()) {
  //      String query = "select 商品ID id, 商品名稱 name,
  //      商品圖片 imageUrl, 商品價格 price, 商品敘述 description"
  //      + " from 商品資料 where name like :keyword";
  //
  //      return connection.createQuery(query)
  //      .addParameter("keyword", "%" + keyword + "%")
  //      .executeAndFetch(Product.class);
  //    }
  //  }
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *@return tag
   *
   */

  public Object getProductsCount() {
    //取得目前商品數量
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "SELECT COUNT(*)" + " FROM `fcu_shop`.`商品資料`;";
      return connection.createQuery(query).executeScalar();
    }
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *@return tag
   *
   */

  public Object getMaxID() {
    //取得最大商品id
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "SELECT max(商品ID)" + " FROM `fcu_shop`.`商品資料`;";
      return connection.createQuery(query).executeScalar();
    }
  }
  /**
   * 註解起來就好了啦.
   *
   *
   *@param product ...
   *@return tag
   *
   */

  public String addProducts(final Product product) {
    //新增商品
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("INSERT INTO `fcu_shop`.`商品資料` "
              + "(`商品ID`, `商品名稱`, `商品圖片`, `商品價格`, `商品敘述`,`商品分類`) "
              + "VALUES (%d,'%s','%s',%d,'%s','%s');", product.getId(),
              product.getName(), product.getImageUrl(),
              product.getPrice(), product.getDescription(),
              product.getClassification());
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
   *@param ID ...
   *@return tag
   *
   */

  public String deleteProducts(final int ID) {
    //刪除特定商品
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("DELETE FROM `fcu_shop`."
              + "`商品資料` WHERE (`商品ID` = '%d');", ID);
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
   *@param ID ...
   *@param NAME ...
   *@param IMAGE_URL ...
   *@param PRICE ...
   *@param DESCRIPTION ...
   *
   *@return tag
   *
   */

  public String updateProducts(final int ID,
                               final String NAME,
                               final String IMAGE_URL,
                               final int PRICE,
                               final String DESCRIPTION) {
    //更新特定商品資料
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("UPDATE `fcu_shop`.`商品資料` SET "
              + "`商品名稱` = '%s', "
              + "`商品圖片` = '%s', `商品價格` = '%d', `商品敘述` = '%s' "
              + "WHERE (`商品ID` = '%d'); ", NAME,
              IMAGE_URL, PRICE, DESCRIPTION, ID);
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "寫入成功";
    } catch (Exception ex) {
      // 除了SQLException以外之錯誤
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }
}

//UPDATE `fcu_shop`.
// `product` SET `NAME` = '日本新谷酵素',
// `IMAGE_URL` = 'https://i.imgur.com/4gtlSqT.png',
// `PRICE` = '66', `DESCRIPTION` = '暗爽！男友誇我瘦下來簡直女神' WHERE (`ID` = '5');