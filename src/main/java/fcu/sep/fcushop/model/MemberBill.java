package fcu.sep.fcushop.model;

public class MemberBill extends Member{
	private String orderID;
	private String state;


	public MemberBill() {

	}


	public MemberBill(String orderID,String imageUrl,String name,String address,String state) {
		this.orderID=orderID;
		this.state = state;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

}
