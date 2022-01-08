package fcu.sep.fcushop.model;

public class Bill extends Product {
	private int count;
	private int sum;
	private String state;

	public Bill() {

	}

	public Bill(String imageUrl, String name, int count, int price, String classification, int sum, String state) {
		this.count = count;
		this.sum = sum;
		this.state = state;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}
