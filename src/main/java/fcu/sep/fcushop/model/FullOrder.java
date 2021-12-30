package fcu.sep.fcushop.model;

public class FullOrder extends Order {
	private int orderID;
	private String productName;
	private String name;
	private String phone;
	public String address;

	public FullOrder() {
	}

	public FullOrder(int orderID, String productName, String name, String phone, String address,int productId,String buyerEmail,int count) {
		this.orderID = orderID;
		this.productName = productName;
		this.name = name;
		this.phone = phone;
		this.address = address;
//		this.productId = productId;
//		this.buyerEmail = buyerEmail;
//		this.count = count;
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
}
