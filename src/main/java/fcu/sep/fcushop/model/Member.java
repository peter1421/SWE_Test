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
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private String email;
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
  private String imageUrl;
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private String phoneNumber;
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
  public Member() {

  }

  /**
   * 註解起來就好了啦.
   *@param email ...
   *@param name ...
   *@param imageUrl ...
   *@param address ...
   *@param phoneNumber ...
   *
   *
   *
   */
  public Member(final String email,
                final String name,
                final String imageUrl,
                final String phoneNumber,
                final String address) {
    this.email = email;
    this.name = name;
    this.imageUrl = imageUrl;
    this.phoneNumber = phoneNumber;
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
  public String getEmail() {
    return email;
  }

  /**
   * 註解起來就好了啦.
   *
   *@param email ...
   *
   *
   *
   */
  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@return tag
   *
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
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param phoneNumber ...
   *
   *
   */
  public void setPhoneNumber(final String phoneNumber) {
    this.phoneNumber = phoneNumber;
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
}
