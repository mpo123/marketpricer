package com.poc.kata.Tools;

import com.poc.kata.Quantity;
import com.poc.kata.Price;

@FunctionalInterface
public interface PromotionHandlerStrategy{

 void apply(Quantity quantity, Price price);

}
