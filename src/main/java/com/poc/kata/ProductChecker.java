package com.poc.kata;

import com.poc.kata.Tools.Common;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(of = { "code", "quantity" })
@Builder
public class ProductChecker {

	@NotNull
	public final String code;
	@Min(1)
	public final Quantity quantity;

	public ProductChecker(@NotNull String code) {
		this.code = code;
		this.quantity = Quantity.builder().value(Common.ONE).build();
	}

	@Override
	public String toString() {
		return String.format(" The Product \"%s\" with \"%d\" quantity", this.code, quantity.getValue());
	}

	public void addQuantity() {
		quantity.addQuantity();
	}
}
