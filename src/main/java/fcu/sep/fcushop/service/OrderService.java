package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Account;
import fcu.sep.fcushop.model.BuyerOrder;
import fcu.sep.fcushop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

import java.util.List;

@Service
public class OrderService {
	@Autowired
	private Sql2oDbHandler sql2oDbHandler;

	public List<Order> getOrder() {
		try (Connection connection = sql2oDbHandler.getConnector().open()) {
			String query = "select 商品ID productId, 買家Email buyerEmail, 商品數量 count"
			+ " from 訂單資料 ";
			System.out.println(query);
			return connection.createQuery(query).executeAndFetch(Order.class);
		}
	}

	public String addOrder(Order order) {
		String returnMessage;
		try (Connection connection = sql2oDbHandler.getConnector().open()) {
			String query = String.format("INSERT INTO `fcu_shop`.`訂單資料` (`商品ID`, `買家Email` ,`商品數量`) VALUES ('%d','%s','%d');", order.getproductId(), order.getbuyerEmail(), order.getcount());
			System.out.println(query);
			connection.createQuery(query, true).executeUpdate().getKey();

			returnMessage = query + "寫入成功";

		} catch (Exception ex)// 除了SQLException以外之錯誤
		{
			returnMessage = "錯誤訊息:" + ex.getMessage();
		}
		return returnMessage;
	}

	public List<BuyerOrder> getBuyerOrder(String Email) {
		try (Connection connection = sql2oDbHandler.getConnector().open()) {
			String query = String.format("SELECT 電子郵件 buyerEmail,訂單ID orderID,商品數量 count,商品名稱 name, 商品價格 price, 商品敘述 description"
			+ " FROM (帳密資料 INNER JOIN 訂單資料 ON 訂單資料.買家EMAIL=帳密資料.電子郵件) INNER JOIN 商品資料 ON 訂單資料.商品ID=商品資料.商品ID"
			+ " where 帳密資料.電子郵件='%s';", Email);
			System.out.println(query);
			return connection.createQuery(query).executeAndFetch(BuyerOrder.class);
		}
	}

	public List<BuyerOrder> getProductOrder(String Email) {
		try (Connection connection = sql2oDbHandler.getConnector().open()) {
			String query = String.format("SELECT 電子郵件 buyerEmail,訂單ID orderID,商品數量 count,商品名稱 name, 商品價格 price, 商品敘述 description"
			+ " FROM (帳密資料 INNER JOIN 訂單資料 ON 訂單資料.買家EMAIL=帳密資料.電子郵件) INNER JOIN 商品資料 ON 訂單資料.商品ID=商品資料.商品ID" + " where 帳密資料.電子郵件='%s';", Email);
			System.out.println(query);
			return connection.createQuery(query).executeAndFetch(BuyerOrder.class);
		}
	}

	public List<BuyerOrder> getSellerOrder(String productId) {
		try (Connection connection = sql2oDbHandler.getConnector().open()) {
			String query = String.format("SELECT 商品名稱 name,電子郵件 buyerEmail,訂單ID orderID,商品數量 count, 商品價格 price, 商品敘述 description"
			+ " FROM (帳密資料 INNER JOIN 訂單資料 ON 訂單資料.買家EMAIL=帳密資料.電子郵件) INNER JOIN 商品資料 ON 訂單資料.商品ID=商品資料.商品ID "
			+ " where 訂單資料.商品ID='%s';", productId);
			System.out.println(query);
			return connection.createQuery(query).executeAndFetch(BuyerOrder.class);
		}
	}
}
