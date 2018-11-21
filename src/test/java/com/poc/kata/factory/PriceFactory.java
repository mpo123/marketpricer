package com.poc.kata.factory;

import com.poc.kata.Price;
import com.poc.kata.Promotion;
import com.poc.kata.Quantity;
import java.math.BigDecimal;

public enum PriceFactory implements AbstractFactory<Price>{

	TEN{
		@Override
		public Price buildObject() {
			return Price.builder().value(new BigDecimal(10)).build();
		}
	},
	TWENTY{
		@Override
		public Price buildObject() {
			return Price.builder().value(new BigDecimal(20)).build();
		}
	},
	TWO{
		@Override
		public Price buildObject() {
			return Price.builder().value(new BigDecimal(2)).build();
		}
	},
	THREE{
		@Override
		public Price buildObject() {
			return Price.builder().value(new BigDecimal(3)).build();
		}
	},
	FIVE
	{
		@Override
		public Price buildObject () {
			return Price.builder().value(new BigDecimal(5)).build();
		}
	},
	FIFTY
	{
		public Price buildObject () {
			return Price.builder().value(new BigDecimal(40)).build();
		}
	},
	FIVE_SIXTY {
		@Override
		public Price buildObject () {
			return Price.builder().value(new BigDecimal(160)).build();
		}
	},
	EIGHTY {
		@Override public Price buildObject() {
			return Price.builder().value(new BigDecimal(80)).build();
		}
	},
	NINETY {
		@Override public Price buildObject() {
			return Price.builder().value(new BigDecimal(90)).build();
		}
	};


	public static Price createPriceWith(BigDecimal value){
		return Price.builder().value(value).build();
	}

}
