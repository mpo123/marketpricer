package com.poc.kata.Tools;

import com.poc.kata.Price;
import com.poc.kata.Product;
import com.poc.kata.Quantity;

@FunctionalInterface
public interface ProductHandlerStrategy {

 void apply(Product product);

}
