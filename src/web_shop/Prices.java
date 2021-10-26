/**
 * 
 */
package web_shop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zolfa
 *
 */
public class Prices {
	private final List<Price> prices = new ArrayList<Price>();

	public Prices () {
		this.initialPrices();
	}

	public List<Price> getPrices() {
		return prices;
	}

	public void initialPrices() {
		// if graduatedPrice of product is true,
		//                      if quantity of product in cart == 1, then the price per product = 100%      
		//                      if quantity of product in cart == 2, then the price per product = 90%
		//                      if quantity of product in cart >= 3, then the price per product = 80% 
		int [] priceQuantity = {1,2,3};
		int [] pricePercentage = {100,90,80};

		for (int i=0; i < priceQuantity.length; i++) {
			this.prices.add(new Price(priceQuantity[i], pricePercentage[i]));
		}
	}

}
