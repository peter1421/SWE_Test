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
  private int productId;
  private String buyerEmail;
  private int count;
  private String state;
  private int billId;

  public Order() {
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  public Order(int productId, String buyerEmail, int count, String state, int billId) {
    this.productId = productId;
    this.buyerEmail = buyerEmail;
    this.count = count;
    this.state = state;
    this.billId = billId;
  }


  public int getproductId() {
    return productId;
  }

  public void setproductId(int productId) {
    this.productId = productId;
  }

  public String getbuyerEmail() {
    return buyerEmail;
  }

  public void setbuyerEmail(String buyerEmail) {
    this.buyerEmail = buyerEmail;
  }

  public int getcount() {
    return count;
  }

  public void setcount(int count) {
    this.count = count;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public int getBillId() {
    return billId;
  }

  public void setBillId(int billId) {
    this.billId = billId;
  }
}

