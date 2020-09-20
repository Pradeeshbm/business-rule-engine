package com.example.pe.businessrule.payment;

import org.springframework.stereotype.Service;

import com.example.pe.businessrule.exception.PaymentException;
import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.payment.postprocessor.PostProcessorChain;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPaymentService implements PaymentService {

	@Override
	public void pay(Item forItem, PostProcessorChain postProcessorChain) {
		validatePayment(forItem);
		process(forItem);
		postProcessorChain.execute(forItem);
	}
	
	private static void validatePayment(Item forItem) {
		if (forItem == null) {
			throw new NullPointerException("Item cannot be null!");
		} else if (forItem.getPrice() < 1) {
			throw new PaymentException("Price must be greater than zero!");
		}
	}
	
	private void process(Item forItem) {
		log.info("Payment successful for the item: {} amount: {}", forItem.getItemName(), forItem.getPrice());
	}
	
}
