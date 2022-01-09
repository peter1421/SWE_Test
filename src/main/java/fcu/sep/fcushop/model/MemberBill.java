package fcu.sep.fcushop.model;

/**
 * 註解起來就好了啦.
 *
 *
 *
 *
 *
 */
public class MemberBill extends Member {
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private String billId;
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
  public MemberBill() {

  }

  /**
   * 註解起來就好了啦.
   *
   *@param billId ...
   *@param name ...
   *@param imageUrl ...
   *@param address ...
   *@param state ...
   *
   *
   *
   */
  public MemberBill(final String billId,
                    final String imageUrl,
                    final String name,
                    final String address,
                    final String state) {
    this.billId = billId;
    this.state = state;
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
   *
   *@return tag
   *
   *
   */
  public String getbillId() {
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
  public void setbillId(final String billId) {
    this.billId = billId;
  }

}
