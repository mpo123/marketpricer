package com.poc.kata;

import com.poc.kata.Tools.PromotionHandlerStrategy;
import com.poc.kata.factory.PriceFactory;
import com.poc.kata.factory.PromitionFactory;
import com.poc.kata.factory.QuantityFactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class PromotionTest {

	Map<Quantity, Promotion> promotionList = new HashMap<>();



	@Before
	public void before(){

	}
	@Test
	public void should_get_rigth_values() throws Exception {
		Quantity expectedQuantity = QuantityFactory.THREE.buildObject();
		Price expectedPrice = PriceFactory.EIGHTY.buildObject();

		Promotion product = Promotion.builder().quantity(QuantityFactory.THREE.buildObject())//
				.price(PriceFactory.EIGHTY.buildObject()).build();

		assertNotNull(product);
		assertThat(product.quantity, is(equalTo(expectedQuantity)));
		assertThat(product.price, is(equalTo(expectedPrice)));
	}


		@Test
	public void product_should_be_elligible_to_promotion (){

		List<Promotion> eligiblePromotion = new ArrayList<>();

		Quantity targetedQuantity = Quantity.builder().value(4).build();

		Quantity quantity1 = Quantity.builder().value(3).build();
		Price price1 = Price.builder().value(new BigDecimal(77.98)).build();
		Promotion promotion1 = Promotion.builder().quantity(quantity1).price(price1).build();

		promotionList.put(quantity1,promotion1);

		Quantity quantity2 = Quantity.builder().value(5).build();
		Price price2 = Price.builder().value(new BigDecimal(88.98)).build();
		Promotion promotion2 = Promotion.builder().quantity(quantity2).price(price2).build();

		promotionList.put(quantity2,promotion2);


		Quantity quantity3 = Quantity.builder().value(2).build();
		Price price3 = Price.builder().value(new BigDecimal(12.99)).build();
		Promotion promotion3 = Promotion.builder().quantity(quantity3).price(price3).build();

		promotionList.put(quantity3,promotion3);
		parsePromotions(
				(currentQuantity,currentPrice)-> { if(!targetedQuantity.isBiggerThan(currentQuantity)) eligiblePromotion.add(Promotion.builder().quantity(currentQuantity).price(currentPrice).build());}
		);
			assertEquals(eligiblePromotion.size(),1);

	}

	public void parsePromotions(@NotNull PromotionHandlerStrategy promotionHandler) {

		List<Quantity> quantities = promotionList.keySet().stream().sorted(Comparator.<Quantity>reverseOrder()).collect(Collectors.toList());
		quantities.forEach(
				currentQuantity ->  {
					Price price = promotionList.get(currentQuantity).price;
					promotionHandler.apply(currentQuantity, price);
				}
		);
	}
}
