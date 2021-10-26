/**
 * 
 */
package web_shop;

/**
 * @author zolfa
 *
 */
public class Price {
	private int idp;
	private static int nextIdp=0;
	private int quantity;
	private int percentage;
	
	public Price(int qauantity, int percentage) {
		this.idp = ++nextIdp;
		this.quantity = qauantity;
		this.percentage = percentage;
	}
	
	public int getIdp() {
		return this.idp;
	}
	
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getPercentage() {
		return this.percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

}
