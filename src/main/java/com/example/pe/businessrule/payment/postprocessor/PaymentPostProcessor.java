package com.example.pe.businessrule.payment.postprocessor;

import com.example.pe.businessrule.model.Item;

/**
 * The Interface PaymentPostProcessor - Used to invoke post payment steps.
 * 
 * @author pradeesh.kumar
 */
public interface PaymentPostProcessor {

	/**
	 * Processes post payment step for the specified item.
	 *
	 * @param item the item
	 */
	void process(Item item);
}
