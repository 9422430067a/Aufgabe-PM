/**
 * 
 */
package web_shop;

import java.util.Objects;

/**
 * @author zolfa
 *
 */
public class Product {

	/**
	 * @param args
	 */
	private char name;               
	private int idp;
	private static int nextIdp=0;
	private int articleNumber;
	private String type;              // normal or digital
	private Category category;
	private float preice; 
	private String[] pictures;
	private int stock;
	private int quantity;             // quantity of product in cart
	private boolean graduatedPrice;   // if true, then the product has more than one price
	private Seller seller;

	public Product(char name,int articleNumber, String type,char categoryName, int parentIdc,
			float preice, String[] pictures, int stock, boolean graduatedPrice, 
			char sellerName, String sellerAddress ) {
		this.name = name;
		this.idp = ++nextIdp;
		this.articleNumber = articleNumber;
		this.type = type;
		this.category = new Category(categoryName, parentIdc);
		this.preice = preice;
		this.pictures = pictures;
		this.stock = stock;
		this.quantity = 0;
		this.graduatedPrice = graduatedPrice;
		this.seller = new Seller(sellerName,sellerAddress );
	}

	public char getName() {
		return this.name;
	}

	public void setName(char name) {
		this.name = name;
	}
	
	public int getIdp() {
		return this.idp;
	}

	public int getArticleNumber() {
		return this.articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSizePictures() {
		return this.pictures.length;     
	}

	public String getPictures(int index) {   
		return this.pictures[index];
	}  

	public void setPictures(int index, String picture) {
		this.pictures[index] = picture;
	}

	public float getPreice() {   
		return this.preice;
	}  

	public void setPreice(float preice) {
		this.preice = preice;
	}
	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity ;
	}
	
	public boolean getGraduatedPrice() {
		return this.graduatedPrice;
	}
	
	public void setGraduatedPrice(boolean graduatedPrice) {
		this.graduatedPrice = graduatedPrice;
	}

	public Seller getSeller() {
		return this.seller;
	}
	
	public void informSeller() {
		// sellers can be informed when a certain product has been sold 
		//     and/or when the stock of a product is empty
	}

}
