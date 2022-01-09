package fcu.sep.fcushop.model;

/**
 * 註解起來就好了啦.
 *
 *
 *
 *
 *
 */
public class BuyerOrder extends Order {
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private int orderID;
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private String name;
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private int price;
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private String description;


  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  public BuyerOrder() {

  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param buyerEmail ...
   *@param orderID ...
   *@param count ...
   *@param name ...
   *@param price ...
   *@param description ...
   *
   *
   */
  public BuyerOrder(final String buyerEmail,
                    final int orderID,
                    final int count,
                    final String name,
                    final int price,
                    final String description) {
    this.orderID = orderID;
    this.name = name;
    this.price = price;
    this.description = description;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  public int getorderID() {
    return orderID;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param orderID ...
   *
   *
   */
  public void setorderID(final int orderID) {
    this.orderID = orderID;
  }



  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  public int getprice() {
    return price;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param price ...
   *
   *
   */
  public void setprice(final int price) {
    this.price = price;
  }


  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  public String getname() {
    return name;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param name ...
   *
   *
   */
  public void setname(final String name) {
    this.name = name;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  public String description() {
    return description;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param description ...
   *
   *
   */
  public void setdescription(final String description) {
    this.description = description;
  }


}
