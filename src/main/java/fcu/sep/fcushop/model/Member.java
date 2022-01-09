package fcu.sep.fcushop.model;

/**
 * 註解起來就好了啦.
 *
 *
 *
 *
 *
 */
public class Member {
  private String email;
  private String name;
  private String imageUrl;
  private String phoneNumber;
  private String address;

  public Member() {

  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  public Member(String email, String name, String imageUrl, String phoneNumber, String address) {
    this.email = email;
    this.name = name;
    this.imageUrl = imageUrl;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
