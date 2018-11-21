package com.poc.kata.factory;

import com.poc.kata.Quantity;

public interface AbstractFactory<T> {

	T buildObject();
}
