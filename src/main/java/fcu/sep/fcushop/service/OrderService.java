package fcu.sep.fcushop.service;
import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

import java.util.List;

@Service
public class OrderService {
	@Autowired
	private Sql2oDbHandler sql2oDbHandler;
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
}
