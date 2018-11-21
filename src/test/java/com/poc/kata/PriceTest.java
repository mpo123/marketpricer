package com.poc.kata;

import com.poc.kata.factory.QuantityFactory;
import com.poc.kata.factory.PriceFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PriceTest {

	@Before
	public void beFore(){

	}

	@Test
	public void should_adding_two_prices() throws Exception {

		Price price = PriceFactory.TEN.buildObject();//TestPrice.TEN.toPrice();
		Price otherPrice = PriceFactory.TEN.buildObject();

		price.addPrice(otherPrice);

		assertEquals(price, PriceFactory.TWENTY.buildObject());

	}

	@Test
	public void should_adding_new_quantity_to_a_price() throws Exception {
		Price price = PriceFactory.TEN.buildObject();
		Quantity multiplier = QuantityFactory.FIVE.buildObject();

		price.addNewQty(multiplier);

		assertEquals(price, PriceFactory.FIFTY.buildObject()); //is(equalTo(TestPrice.FIFTY.toPrice()))
	}

}
