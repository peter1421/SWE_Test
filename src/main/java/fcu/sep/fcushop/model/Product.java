package fcu.sep.fcushop.model;

/**
 * 註解起來就好了啦.
 *
 *
 *
 *
 *
 */
public class Product {

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  private long id;

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
  private String classification;

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   */
  public Product() {
  }

  /**
   * 註解起來就好了啦.
   *
   *@param id ...
   *@param name ...
   *@param imageUrl ...
   *@param price ...
   *@param description ...
   *@param classification ...
   *
   *
   */
  public Product(final long id,
                 final String name,
                 final String imageUrl,
                 final int price,
                 final String description,
                 final String classification) {
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
    this.price = price;
    this.description = description;
    this.classification = classification;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *@return tag
   *
   */
  public long getId() {
    return id;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param id ...
   *
   *
   */
  public void setId(final long id) {
    this.id = id;
  }

  /**
   * 註解起來就好了啦.
   *
   *@return tag
   *
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
   *
   *@return tag
   *
   */
  public String getImageUrl() {
    return imageUrl;
  }

  /**
   * 註解起來就好了啦.
   *
   *@param imageUrl ...
   *
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
   *
   *@return tag
   *
   */
  public int getPrice() {
    return price;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *@param price ...
   *
   */
  public void setPrice(final int price) {
    this.price = price;
  }

  /**
   * 註解起來就好了啦.
   *
   *@return tag
   *
   *
   *
   */
  public String getDescription() {
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
  public void setDescription(final String description) {
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
  public String getClassification() {
    return classification;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *@param classification ...
   *
   */
  public void setClassification(final String classification) {
    this.classification = classification;
  }
}
