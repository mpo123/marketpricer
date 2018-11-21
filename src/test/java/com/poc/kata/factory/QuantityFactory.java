package com.poc.kata.factory;

import com.poc.kata.Quantity;
import java.util.Random;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

//@AllArgsConstructor(access = AccessLevel.PACKAGE)
public enum QuantityFactory implements AbstractFactory<Quantity>{

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

		static final Random biggerThanOneRamdon = new Random();

		public @NonNull static Quantity createQuantityFor(int withValue) { return Quantity.builder().value(withValue).build(); }
		public static @NonNull Quantity createBiggerThanOneQuantity() { return Quantity.builder().value(Math.abs(biggerThanOneRamdon.nextInt())+1).build();}

}