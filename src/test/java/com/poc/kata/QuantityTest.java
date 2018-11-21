package com.poc.kata;

import com.poc.kata.factory.QuantityFactory;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class QuantityTest {


	@Before
	public void beFore(){

	}
	@Test
	public void shouldBeZeroValue() throws Exception {

	}

	@Test
	public void shouldBeNotZeroValue() throws Exception {
		Quantity quantity = QuantityFactory.ONE.buildObject();
		assertFalse(quantity.isNone());
	}

	@Test
	public void shouldBeOneValue() throws Exception {
		Quantity quantity = QuantityFactory.ONE.buildObject();
		assertTrue(quantity.isOne());
	}

	@Test
	public void shouldBeNotOneValue() throws Exception {
		Quantity quantity = QuantityFactory.None.buildObject();
		assertFalse(quantity.isOne());
	}

	@Test
	public void product_quantity_should_be_less_than_fixed_quantity() throws Exception {
		Quantity productQuantity = QuantityFactory.ONE.buildObject();
		Quantity fixedQuantity = QuantityFactory.createBiggerThanOneQuantity();
		assertTrue(fixedQuantity.isBiggerThan(productQuantity));
	}

}
