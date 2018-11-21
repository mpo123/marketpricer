package com.poc.kata.factory;

import com.poc.kata.Price;
import com.poc.kata.Product;
import com.poc.kata.Promotion;
import com.poc.kata.PromotionService;

public class ProductFactory {

	public static Product createProductWithFiftyPrice(Promotion promotion){
		Price priceA = PriceFactory.FIFTY.buildObject();
		PromotionService promotionService = PromotionService.builder().build();promotionService.addPromotion(promotion);
		return Product.builder().code("PRODUCT_1").price(priceA).promotionService(promotionService).build();
	}


}
