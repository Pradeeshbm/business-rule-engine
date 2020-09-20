package com.example.pe.businessrule.payment;

import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.payment.postprocessor.PaymentPostProcessor;

public interface PaymentService {
	
	void pay(Item item, PaymentPostProcessor postProcessor);
}
