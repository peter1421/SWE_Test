package fcu.sep.fcushop.model;

/**
 * 註解起來就好了啦.
 *
 *
 *
 *
 *
 */
public class FullOrder extends Order {
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
  private String productName;
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
  private String phone;
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private String address;
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
  private String imageUrl;
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private String classification;

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  public FullOrder() {
  }

  /**
   * 註解起來就好了啦.
   *
   *@param orderID ...
   *@param productName ...
   *@param name ...
   *@param phone ...
   *@param address ...
   *@param productId ...
   *@param buyerEmail ...
   *@param count ...
   *@param price ...
   *@param imageUrl ...
   *@param classification ...
   *
   *
   *
   */
  public FullOrder(final int orderID,
                   final String productName,
                   final String name,
                   final String phone,
                   final String address,
                   final int productId,
                   final String buyerEmail,
                   final int count,
                   final int price,
                   final String imageUrl,
                   final String classification) {
    this.orderID = orderID;
    this.productName = productName;
    this.name = name;
    this.phone = phone;
    this.address = address;
    this.price = price;
    this.imageUrl = imageUrl;
    this.classification = classification;
    //this.productId = productId;
    //this.buyerEmail = buyerEmail;
    //this.count = count;
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
   *@param orderID ...
   *
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
  public String getproductName() {
    return productName;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param productName ...
   *
   *
   */
  public void setproductName(final String productName) {
    this.productName = productName;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *@return tag
   *
   */
  public String getName() {
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
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * 註解起來就好了啦.
   *
   *@return tag
   *
   *
   *
   */
  public String getPhone() {
    return phone;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param phone ...
   *
   *
   */
  public void setPhone(final String phone) {
    this.phone = phone;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  public String getAddress() {
    return address;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param address ...
   *
   *
   */
  public void setAddress(final String address) {
    this.address = address;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  public int getPrice() {
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
  public void setPrice(final int price) {
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
  public String getImageUrl() {
    return imageUrl;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param imageUrl ...
   *
   *
   */
  public void setImageUrl(final String imageUrl) {
    this.imageUrl = imageUrl;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
   *
   */
  public String getClassification() {
    return classification;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param classification ...
   *
   *
   */
  public void setClassification(final String classification) {
    this.classification = classification;
  }
}
