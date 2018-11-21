package com.poc.kata;

import com.poc.kata.Tools.PromotionHandlerStrategy;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Builder
public class PromotionService {

	@Getter
	private final Map<Quantity, Promotion> promotionList;

	public PromotionService(Map<Quantity, Promotion> promotionList) {
		promotionList = new HashMap<Quantity, Promotion>();
		this.promotionList = promotionList;
	}

	public PromotionService() {
		promotionList = new HashMap<Quantity, Promotion>();
	}

	public void addPromotion(Promotion promo){
		promotionList.put(promo.quantity, promo);
	}

	public void parsePromotions(@NotNull PromotionHandlerStrategy promotionHandler) {
		List<Quantity> quantities = promotionList.keySet().stream().sorted(Comparator.<Quantity>reverseOrder()).collect(Collectors.toList());
		quantities.forEach(
				currentQuantity ->  {
					Price price = promotionList.get(currentQuantity).price;
					promotionHandler.apply(currentQuantity, price);
				}
		);

	}


}
