package com.poc.kata;

import com.poc.kata.Tools.Common;
import java.awt.font.NumericShaper;
import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode(of={"code","price"})
@ToString(of = {"code","price"})
public class Product {

	@NonNull
	@Getter
	private final String code;
	@NonNull
	private final Price price;

	@NotNull
	private final PromotionService promotionService;

	@NotNull
	private final SellingUnit sellingUnit;

	@Builder
	public Product(String code, Price price, PromotionService promotionService){
		this.code = code;
		this.price = price;
		this.sellingUnit = SellingUnit.NUMERIC;
		this.promotionService = promotionService;
	}

	@NotNull
	public Price getPriceForQuantity(int quantity) {
		final Price resultPrice = Price.builder().value(new BigDecimal(Common.NONE)).build();
		final Quantity quantityOfProduct = Quantity.builder().value(quantity).build();

		if(sellingUnit.isNumericUnit())
		promotionService.parsePromotions((productQuantityForPromotion, priceForPromition) -> {
			if (!productQuantityForPromotion.isBiggerThan(quantityOfProduct)) {
				quantityOfProduct.subtract(productQuantityForPromotion);
				resultPrice.addPrice(priceForPromition);
			}
		});


		if (!quantityOfProduct.isNone()) {
			Price productPrice = price.addNewQty(quantityOfProduct);
			resultPrice.addPrice(productPrice);
		}

		return resultPrice;
	}


	enum SellingUnit
	{
		NUMERIC("NUMERIC"), //simple Product
		PIECE("PIECE"); // complexe product

		@NotEmpty
		private final String code;

		SellingUnit(String code){this.code = code;}

		public boolean isNumericUnit(){
			return NUMERIC.equals(this);
		}
	}
}
