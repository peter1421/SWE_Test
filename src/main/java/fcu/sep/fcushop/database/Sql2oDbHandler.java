package fcu.sep.fcushop.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.sql2o.Sql2o;

/**
 * 註解起來就好了啦.
 *
 *
 *
 *
 *
 */
@Service
@PropertySource("classpath:application.properties")
public class Sql2oDbHandler {

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  @Value("${db.jdbc_url}")
  private String jdbcUrl;

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  @Value("${db.username}")
  private String userName;

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  @Value("${db.password}")
  private String password;

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private Sql2o connector;

  /**
   * Get sql2o connector.
   *
   * @return connector
   */
  public Sql2o getConnector() {
    if (connector == null) {
      connector = new Sql2o(jdbcUrl, userName, password);
      //System.out.println("連線"+jdbcUrl+userName+password);
    }
    return connector;
  }
}