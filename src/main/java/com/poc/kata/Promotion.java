package com.poc.kata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
public class Promotion {

	@Getter
	public final Quantity quantity;
	@Getter
	public final Price  price;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o.getClass() == this.getClass()))
			return false;

		Promotion that = (Promotion) o;

		if (!this.getQuantity().equals(this.getQuantity()))
			return false;
		return getPrice().equals(that.getPrice());

	}


	@Override
	public int hashCode() {
		int result = this.getQuantity().hashCode();
		result = 31 * result + getPrice().hashCode();
		return result;
	}


}
