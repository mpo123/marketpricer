package com.poc.kata;

import java.math.BigDecimal;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
@EqualsAndHashCode(of={"value"})
@Builder
@ToString(of = "value")
public class Price{

	@NonNull
	@Getter
	@Size(min = 1)
	private BigDecimal value;

	@NonNull
	public Price addPrice(@NonNull Price otherPrice) {
		value = value.add(otherPrice.value);
		return this;
	}

	@NonNull
	public Price addNewQty(@NonNull Quantity newQuantity) {
		BigDecimal multiplier = BigDecimal.valueOf(newQuantity.getValue());
		value = value.multiply(multiplier);
		return this;
	}

}
