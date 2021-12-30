package fcu.sep.fcushop.model;

public class FullOrder extends Order {
	private int orderID;
	private String productName;
	private String name;
	private String phone;
	public String address;

	public FullOrder() {

	}

	//之後可能會繼承其他資訊
	public FullOrder(int orderID, String productName, String name, String phone, String address) {
		this.orderID = orderID;
		this.productName = productName;
		this.name = name;
		this.phone = phone;
		this.address = address;
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

	public void setproductName() {
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
