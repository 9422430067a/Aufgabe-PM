package web_shop;

public class Category {
	private char name;
	private int idc;
	private static int nextIdc=0;
	private int parentIdc;

	public Category(char name, int parentIdc) {
		this.idc = ++nextIdc;
		this.name = name;
		this.parentIdc = parentIdc;
	}

	public int getIdc() {
		return this.idc;
	}
	
	public char getName() {
		return this.name;
	}

	public void setName(char name) {
		this.name = name;
	}
	
	public int getParentIdc() {
		return this.parentIdc;
	}

	public void setparentIdc(int parentIdc) {
		this.parentIdc = parentIdc;
	}
	
	public void displayCategories() {
		// to display hierarchy of categories
	}
	
	public void displayProductsOfCategory() {
		// to display products of a certain category 
	}

}
