package fcu.sep.fcushop.model;

/**
 * 註解起來就好了啦.
 *
 *
 *
 *
 *
 */
public class Order {
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private int productId;
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private String buyerEmail;
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private int count;
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private String state;
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private int billId;

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  public Order() {
  }

  /**
   * 註解起來就好了啦.
   *
   *@param productId ...
   *@param buyerEmail ...
   *@param count ...
   *@param state ...
   *@param billId ...
   *
   *
   *
   */
  public Order(final int productId,
               final String buyerEmail,
               final int count,
               final String state,
               final int billId) {
    this.productId = productId;
    this.buyerEmail = buyerEmail;
    this.count = count;
    this.state = state;
    this.billId = billId;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  public int getproductId() {
    return productId;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param productId ...
   *
   *
   */
  public void setproductId(final int productId) {
    this.productId = productId;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *@return tag
   *
   */
  public String getbuyerEmail() {
    return buyerEmail;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param buyerEmail ...
   *
   *
   */
  public void setbuyerEmail(final String buyerEmail) {
    this.buyerEmail = buyerEmail;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  public int getcount() {
    return count;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param count ...
   *
   *
   */
  public void setcount(final int count) {
    this.count = count;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  public String getState() {
    return state;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param state ...
   *
   *
   */
  public void setState(final String state) {
    this.state = state;
  }

  /**
   * 註解起來就好了啦.
   *
   *@return tag
   *
   *
   *
   */
  public int getBillId() {
    return billId;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param billId ...
   *
   *
   */
  public void setBillId(final int billId) {
    this.billId = billId;
  }
}

