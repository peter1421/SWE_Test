package fcu.sep.fcushop.model;

public class BuyerOrder {
	private String buyerEmail;
	private int orderID;
	private int count;
	private String name;
	private int price;
	private String description;


	public BuyerOrder() {

	}

	public BuyerOrder(String buyerEmail, int orderID, int count, String name, int price, String description) {
		this.buyerEmail = buyerEmail;
		this.orderID = orderID;
		this.count = count;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public int getorderID() {
		return orderID;
	}

	public void setorderID(int orderID) {
		this.orderID = orderID;
	}

	public int getcount() {
		return count;
	}

	public void setcount(int count) {
		this.count = count;
	}

	public int getprice() {
		return price;
	}

	public void setprice(int price) {
		this.price = price;
	}


	public String getbuyerEmail() {
		return buyerEmail;
	}

	public void setbuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}


	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}


	public String description() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}


}
