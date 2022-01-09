package fcu.sep.fcushop.model;

public class MemberBill extends Member{
	private String billId;
	private String state;


	public MemberBill() {

	}


	public MemberBill(String billId,String imageUrl,String name,String address,String state) {
		this.billId=billId;
		this.state = state;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getbillId() {
		return billId;
	}

	public void setbillId(String billId) {
		this.billId = billId;
	}

}
