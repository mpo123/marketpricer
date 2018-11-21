package com.poc.kata;

import com.poc.kata.Tools.Common;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@AllArgsConstructor
@EqualsAndHashCode(of={"code","price"})
@Builder
public class ProductService {

	private final Map<String, Product> productList;


	public ProductService() {
		this.productList = new HashMap<>();
	}

	public void addProduct(@NotNull Product product) throws IllegalStateException {

		productList.put(product.getCode(), product);
	}

	@NotNull
	public Optional<Product> findProductByName(String code) {
		return Optional.ofNullable(productList.get(code));
	}


}
