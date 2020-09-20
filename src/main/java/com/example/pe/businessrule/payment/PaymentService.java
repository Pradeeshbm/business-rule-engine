package com.example.pe.businessrule.payment;

import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.payment.postprocessor.PostProcessorChain;

/**
 * The Interface PaymentService.
 * 
 * @author pradeesh.kumar
 */
public interface PaymentService {
	
	/**
	 * Performs the payment for item.
	 * Execute post processor chain only for the successful payment.
	 *
	 * @param item the item for which payment to be made
	 * @param postProcessorChain the payment post processor chain
	 */
	void pay(Item item, PostProcessorChain postProcessorChain);
}
