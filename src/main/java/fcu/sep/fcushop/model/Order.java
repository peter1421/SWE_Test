package fcu.sep.fcushop.model;

public class Order {
	private int productId;
	private String buyerEmail;
	private int count;
	private String state;


	public Order() {
	}

	public Order(int productId, String buyerEmail, int count,String state) {
		this.productId = productId;
		this.buyerEmail = buyerEmail;
		this.count = count;
		this.state=state;
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

	public  String getState(){return state;}

	public void setState(String state){this.state = state;}
}

