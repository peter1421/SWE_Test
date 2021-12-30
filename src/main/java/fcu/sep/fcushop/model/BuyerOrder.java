package fcu.sep.fcushop.model;

public class BuyerOrder extends Order{
	private int orderID;
	private String name;
	private int price;
	private String description;


	public BuyerOrder() {

	}

	public BuyerOrder(String buyerEmail, int orderID, int count, String name, int price, String description) {
		this.orderID = orderID;
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



	public int getprice() {
		return price;
	}

	public void setprice(int price) {
		this.price = price;
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
