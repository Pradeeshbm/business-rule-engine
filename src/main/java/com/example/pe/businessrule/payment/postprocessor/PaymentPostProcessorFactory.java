package com.example.pe.businessrule.payment.postprocessor;

import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.model.PhysicalProduct;

public final class PaymentPostProcessorFactory {

	private PaymentPostProcessorFactory() {}
	
	public static PaymentPostProcessor create(Item item) {
		if (item instanceof PhysicalProduct) {
			return new PackingSlipProcessor();
		}
		return null;
	}
}
