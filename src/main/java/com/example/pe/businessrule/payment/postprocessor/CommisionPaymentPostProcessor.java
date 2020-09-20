package com.example.pe.businessrule.payment.postprocessor;

import com.example.pe.businessrule.model.Item;

import lombok.extern.slf4j.Slf4j;

/**
 * If the payment is for a physical product or a book, generate a commission
 * payment to the agent.
 * 
 * @author pradeesh.kumar
 */
@Slf4j
public class CommisionPaymentPostProcessor implements PaymentPostProcessor {

	/**
	 * Generate commission payment to the agent
	 *
	 * @param item the item
	 */
	@Override
	public void process(Item item) {
		log.info("Generating commision payment for the item: {}", item.getItemName());
	}

}
