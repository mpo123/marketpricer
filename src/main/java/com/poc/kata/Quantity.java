package com.poc.kata;
import com.poc.kata.Tools.Common;
import java.io.Serializable;
import javax.validation.Validation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode(of={"value"})
@Builder
@ToString(of = {"value"})
public class Quantity implements Comparable<Quantity>,Serializable{

	@NotNull
	@Getter
	@Size(min = 0, message = "The quantity must be >0")
	private Integer value;

	public boolean isNone() {
		return value == Common.NONE;
	}

	public boolean isOne() {
		return value == Common.ONE;
	}

	public boolean isBiggerThan(Quantity other) {
		return  value > other.value;
	}

	public void subtract(Quantity quantity) {
		value -= quantity.getValue();
	}

	public void addQuantity() {
		value++;
	}

	@Override
	public int compareTo(@NotNull Quantity other) {
		return Integer.compare(getValue(), other.getValue());
	}
}
