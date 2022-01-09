package fcu.sep.fcushop.model;

/**
 * 註解起來就好了啦.
 *
 *
 *
 *
 *
 */
public class Bill extends Product {
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
  private int sum;
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
  public Bill() {

  }

  /**
   * 註解起來就好了啦.
   *
   *@param imageUrl ...
   *@param name ...
   *@param count ...
   *@param price ...
   *@param classification ...
   *@param sum ...
   *@param state ...
   *
   *
   *
   */
  public Bill(final String imageUrl,
              final String name,
              final int count,
              final int price,
              final String classification,
              final int sum,
              final String state) {
    this.count = count;
    this.sum = sum;
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
  public int getCount() {
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
  public void setCount(final int count) {
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
   *
   *@return tag
   *
   *
   */
  public int getSum() {
    return sum;
  }

  /**
   * 註解起來就好了啦.
   *
   *@param sum ...
   *
   *
   *
   */
  public void setSum(final int sum) {
    this.sum = sum;
  }

}
