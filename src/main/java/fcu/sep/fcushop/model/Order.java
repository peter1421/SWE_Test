package fcu.sep.fcushop.model;

public class Order {

	private int productId;
	private String buyerEmail;
	private int count;

	public Order() {
	}

	public Order(int productId, String buyerEmail, int count) {
		this.productId = productId;
		this.buyerEmail = buyerEmail;
		this.count = count;

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


}

