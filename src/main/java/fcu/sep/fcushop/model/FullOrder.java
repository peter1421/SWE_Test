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
  private int orderID;
  private String productName;
  private String name;
  private String phone;
  private String address;
  private int price;
  private String imageUrl;
  private String classification;

  public FullOrder() {
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  public FullOrder(int orderID,
                   String productName,
                   String name,
                   String phone,
                   String address,
                   int productId,
                   String buyerEmail,
                   int count,
                   int price,
                   String imageUrl,
                   String classification) {
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

  public int getorderID() {
    return orderID;
  }

  public void setorderID(int orderID) {
    this.orderID = orderID;
  }

  public String getproductName() {
    return productName;
  }

  public void setproductName(String productName) {
    this.productName = productName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }


  public String getClassification() {
    return classification;
  }

  public void setClassification(String classification) {
    this.classification = classification;
  }
}
