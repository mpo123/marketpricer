package com.poc.kata.factory;

import com.poc.kata.Quantity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

public enum CommonValues{

	None{
		@Override
		public Quantity buildObject() {
			return Quantity.builder().value(0).build();
		}
	},
	ONE{
		@Override
		public Quantity buildObject() {
			return Quantity.builder().value(1).build();
		}
	},
	TWO{
		@Override
		public Quantity buildObject() {
			return Quantity.builder().value(2).build();
		}
	},
	THREE{
		@Override
		public Quantity buildObject() {
			return Quantity.builder().value(3).build();
		}
		},
	FIVE{
			public Quantity buildObject() {
				return Quantity.builder().value(4).build();
			}

	};

	public abstract Quantity buildObject();
}
