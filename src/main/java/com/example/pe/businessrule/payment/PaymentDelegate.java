package com.example.pe.businessrule.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.payment.postprocessor.PaymentPostProcessorFactory;

@Component
public class PaymentDelegate {

	@Autowired
	private PaymentService paymentService;
	
	public void pay(Item item) {
		paymentService.pay(item, PaymentPostProcessorFactory.create(item));
	}
}
