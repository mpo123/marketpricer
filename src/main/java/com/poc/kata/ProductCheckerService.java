package com.poc.kata;

import com.poc.kata.Tools.Common;
import com.poc.kata.Tools.ProductHandlerStrategy;
import com.poc.kata.Tools.PromotionHandlerStrategy;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
public class ProductCheckerService {

	private final Map<String, ProductChecker> checkedProduct;

	public ProductCheckerService() {
		checkedProduct = new HashMap<>();
	}

	public void insertCheckedProduct(@NotNull String code) {
		checkedProduct.computeIfPresent(code, (currentExictedProductCode, currentCheckedProduct) -> {
			currentCheckedProduct.addQuantity();
			return currentCheckedProduct;
		});
		checkedProduct.putIfAbsent(code, new ProductChecker(code));
	}

	public void parsePruductList(@NotNull Consumer<ProductChecker> productHandlerStrategy) {
		checkedProduct.values().stream().forEach(productHandlerStrategy);
	}

}
