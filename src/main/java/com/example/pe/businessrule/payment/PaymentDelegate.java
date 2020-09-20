package com.example.pe.businessrule.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.payment.postprocessor.PaymentPostProcessorFactory;

/**
 * The Class PaymentDelegate - To hide other than business logic codes such as
 * creating post processor for item from factory etc.
 * 
 * @author pradeesh.kumar
 */
@Component
public class PaymentDelegate {

	@Autowired
	private PaymentService paymentService;
	
	/**
	 * Performs the payment for specified item.
	 * Execute post processor chain only for the successful payment.
	 *
	 * @param item the item
	 */
	public void pay(Item item) {
		paymentService.pay(item, PaymentPostProcessorFactory.create(item));
	}
}
