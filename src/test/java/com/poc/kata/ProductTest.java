package com.poc.kata;

import com.poc.kata.Tools.Common;
import com.poc.kata.factory.QuantityFactory;
import com.poc.kata.factory.PriceFactory;
import com.poc.kata.factory.ProductFactory;
import com.poc.kata.factory.PromitionFactory;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ProductTest {

	private Product product;

	static int NIVETY = 90;

	@Before
	public void setUp() throws Exception {
		Promotion promotionA = PromitionFactory.FIVE_TEN.buildObject();
		product = ProductFactory.createProductWithFiftyPrice(promotionA);
	}


	@Test
	public void should_not_apply_any_promotion_and_calculate_simple_price() throws Exception {
		Price price = product.getPriceForQuantity(QuantityFactory.ONE.buildObject().getValue());
		assertEquals(price, PriceFactory.FIFTY.buildObject());
	}
	@Test
	public void should_not_apply_any_promotion_and_calculate_simple_price_case2() throws Exception {
		Price price = product.getPriceForQuantity(QuantityFactory.TWO.buildObject().getValue());
		assertEquals(price, PriceFactory.EIGHTY.buildObject());
	}
	@Test
	public void should_not_apply_promotion() throws Exception {
		Price price = product.getPriceForQuantity(QuantityFactory.FIVE.buildObject().getValue());
		assertEquals(price, PriceFactory.TEN.buildObject());
	}
	@Test
	public void should_not_apply_promotion2() throws Exception {
		Price price = product.getPriceForQuantity(QuantityFactory.THREE.buildObject().getValue()); // 3*40 = 120
		assertEquals(price.getValue(), new BigDecimal(3*40));
	}

	@Test
	public void should_apply_promotion_FIVE_SELL_GIVE_TEEN() throws Exception {
		Price price = product.getPriceForQuantity(6); // 3*40 = 120
		assertEquals(price, PriceFactory.NINETY.buildObject());

	}

}
