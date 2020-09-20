package com.example.pe.businessrule.payment.postprocessor;

import com.example.pe.businessrule.model.Item;

public interface PaymentPostProcessor {

	void process(Item item);
}
