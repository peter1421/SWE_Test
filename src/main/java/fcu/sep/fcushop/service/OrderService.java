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
			String query = "select 商品ID productId, 買家Email buyerEmail, 數量 count"
			+ " from 訂單 ";
			System.out.println(query);
			return connection.createQuery(query).executeAndFetch(Order.class);
		}
	}

	public String addOrder(Order order) {
		String returnMessage;
		try (Connection connection = sql2oDbHandler.getConnector().open()) {
			String query = String.format("INSERT INTO `fcu_shop`.`訂單` (`商品ID`, `買家Email` ,`數量`) VALUES ('%d','%s','%d');",order.getproductId(),order.getbuyerEmail(),order.getcount());
			System.out.println(query);
			//INSERT INTO `fcu_shop`.`訂單` (`商品ID`, `買家Email`, `數量`) VALUES ('2', '2', '2');
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
			String query = String.format("SELECT EMAIL buyerEmail,訂單ID orderID,數量 count,NAME name, PRICE price, DESCRIPTION description"
			+ " FROM (account_basic INNER JOIN 訂單 ON 訂單.買家EMAIL=account_basic.EMAIL) INNER JOIN product ON 訂單.商品ID=product.ID"+" where account_basic.EMAIL='%s';",Email);
			System.out.println(query);

			return connection.createQuery(query).executeAndFetch(BuyerOrder.class);
		}
	}
}
