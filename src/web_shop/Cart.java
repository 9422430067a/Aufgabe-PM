package web_shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	List<Product> cartProducts = new ArrayList<Product>();
	List<Product> products = new Products().getProducts();
	List<Price> prices = new Prices().getPrices();
	
	public void addProductToCartByIdp(int idp) {
		Product product = getProductByIdp(idp);
		addToCart(product);
	}

	public Product getProductByIdp(int idp) {
		Product product = null;
		for (Product prod: products) {
			if (prod.getIdp() == idp) {
				product = prod;
				break;
			}
		}
		return product;

	}

	private void addToCart(Product product) {
		updateQuantity(product, "add");	
		if ( !checkProductInCart(product) )        // if cartProducts is null or the product is added for the first time
			if( product.getType() == "digital" || product.getStock() > 0 ) 
				cartProducts.add(product);	

	}

	public boolean checkProductInCart(Product product) {
		if( cartProducts == null)
			return false;
		else {
			for ( Product prod: cartProducts ) {
				if( product.getIdp() == prod.getIdp() ) {
					return true;
				}
			}
			return false;
		}
	}

	public void removeProductByIdp(int idp) {
		Product product = getProductByIdp(idp);
		if ( checkProductInCart(product) ) 
			updateQuantity(product, "remove");
	}

	public void updateQuantity(Product product, String function) {
		int quantity = product.getQuantity();
		int stock = product.getStock();
		String type =product.getType();
		if( function == "add") {
			if( product.getType() == "digital" || product.getStock() > 0 ) 
				quantity++;
			if ( type == "normal")
				stock--;
		}
		else {                       // remove product 
			quantity--;
			if ( quantity <= 0 )
				cartProducts.remove(product);
			if ( type == "normal")
				stock++;
		}
		product.setQuantity(quantity);
		if ( type == "normal") {
			product.setStock(stock);
			if ( product.getStock() <= 0)
				product.informSeller();
		}
	}

	void displayCartProducts() {
		for (Product prod: cartProducts) {
			System.out.println("Product Name : " + prod.getName() +
					" Article Number : " + prod.getArticleNumber() +
					" Quantity : " + prod.getQuantity() +
					" Price : " + getPriceOfProduct(prod)+ "/n");
		}
		System.out.println("Total Price is :  " + getTotalPrice());
	}
	
	public float getPriceOfProduct(Product prod) {
		float price = 0;
		if ( prod.getGraduatedPrice()) {
			for (Price pr: prices) {
				if (pr.getQuantity() == prod.getQuantity())
					price = prod.getPreice()* prod.getQuantity()* pr.getPercentage();
			}
			if (price == 0)
				price = prod.getPreice()* prod.getQuantity()* prices.get(prices.size()).getPercentage();
		
		}
		else
			price = prod.getPreice()* prod.getQuantity();
		return price;
	}
	
	public float getTotalPrice() {
		float totalPrice = 0;
		for (Product prod: cartProducts ) {
			if ( prod.getGraduatedPrice()) {
				for (Price price: prices) {
					if (price.getQuantity() == prod.getQuantity())
						totalPrice += prod.getPreice()* prod.getQuantity()* price.getPercentage();
				}
				if (totalPrice == 0)
					totalPrice += prod.getPreice()* prod.getQuantity()* prices.get(prices.size()).getPercentage();
			}
			else
				totalPrice += prod.getPreice()* prod.getQuantity();
		}
		return totalPrice;
	}
	
	public void purchase() {
		for (Product prod: cartProducts ) {
			if (prod.getType() == "digital") {
				// when buying digital product, either a download link is generated or an e-mail is sent
			}
			else {
				// The normal products are sent by post
			}
		}
		cartProducts.clear();
	}
}
