package com.example.pe.businessrule.payment;

import org.springframework.stereotype.Service;

import com.example.pe.businessrule.exception.PaymentException;
import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.payment.postprocessor.PostProcessorChain;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class DefaultPaymentService.
 * 
 * @author pradeesh.kumar
 */
@Service
@Slf4j
public class DefaultPaymentService implements PaymentService {

	/**
	 * Performs the payment for item.
	 * Execute post processor chain only for the successful payment.
	 *
	 * @param item the item for which payment to be made
	 * @param postProcessorChain the payment post processor chain
	 * @throws NullPointerException if the item is null
	 * @throws PaymentException if amount is null or any uncertain error during payment.
	 */
	@Override
	public void pay(Item forItem, PostProcessorChain postProcessorChain) {
		validatePayment(forItem);
		process(forItem);
		postProcessorChain.execute(forItem);
	}
	
	/**
	 * Checks if the item is null or specified price is valid or not.
	 *
	 * @param forItem the for item
	 */
	private static void validatePayment(Item forItem) {
		if (forItem == null) {
			throw new NullPointerException("Item cannot be null!");
		} else if (forItem.getPrice() < 1) {
			throw new PaymentException("Price must be greater than zero!");
		}
	}
	
	/**
	 * Process the payment for item.
	 *
	 * @param forItem the for item
	 */
	private void process(Item forItem) {
		log.info("Payment successful for the item: {} amount: {}", forItem.getItemName(), forItem.getPrice());
	}
	
}
