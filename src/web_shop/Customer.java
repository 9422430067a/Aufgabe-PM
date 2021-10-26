/**
 * 
 */
package web_shop;

/**
 * @author zolfa
 *
 */
public class Customer {
	private int idc;
	private static int nextIdc=0;
	private char name;
	private String address;

	public Customer(char name, String address) {
		this.idc = ++nextIdc;
		this.name = name;
		this.address = address;
	}

	public char getName() {
		return this.name;
	}

	public void setName(char name) {
		this.name = name;
	}
	public int getIdc() {
		return this.idc;
	}
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void informCustomer(int productName) {
		// customer can be informed by mail when the price of a certain product 
		//    has been updated
	}

}
