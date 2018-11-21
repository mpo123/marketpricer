package com.poc.kata.factory;

import com.poc.kata.Price;
import com.poc.kata.Promotion;
import com.poc.kata.Quantity;
import java.math.BigDecimal;

public enum PromitionFactory implements AbstractFactory<Promotion>{

	TEN_FIVE
	{
		@Override
		public Promotion buildObject() {
		Price sellingPrice = Price.builder().value(TEN).build();
		Quantity givenQuantity = QuantityFactory.FIVE.buildObject();
		return Promotion.builder().quantity(givenQuantity).price(sellingPrice).build();
	}
	},
	ONE_TWO
	{
		@Override
		public Promotion buildObject () {
			Price sellingPrice = Price.builder().value(TWO).build();
			Quantity givenQuantity = QuantityFactory.ONE.buildObject();
			return Promotion.builder().quantity(givenQuantity).price(sellingPrice).build();
		}
	},
	FIVE_TEN
			{
				@Override
				public Promotion buildObject () {
					Price sellingPrice = Price.builder().value(TEN).build();
					Quantity givenQuantity = QuantityFactory.FIVE.buildObject();
					return Promotion.builder().quantity(givenQuantity).price(sellingPrice).build();
				}
			};



	static final BigDecimal TEN = new BigDecimal(10);

	static final BigDecimal TWENTY = new BigDecimal(20);

	static final BigDecimal FIFTY = new BigDecimal(40);

	static final BigDecimal TWO = new BigDecimal(2);

	public static Price createPromotionWith(BigDecimal value) {
		return Price.builder().value(value).build();
	}

}
