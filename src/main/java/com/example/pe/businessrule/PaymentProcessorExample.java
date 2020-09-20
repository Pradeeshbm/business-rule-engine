package com.example.pe.businessrule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pe.businessrule.model.Book;
import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.payment.PaymentDelegate;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class PaymentProcessorExample - just test for Book payment.
 * More test cases written under test source.
 * 
 * @author pradeesh.kumar
 */
@Component
@Slf4j
public class PaymentProcessorExample {

	/** The payment delegate. */
	@Autowired
	private PaymentDelegate paymentDelegate;
	
	public void test() {
		testBook();
	}
	
	/**
	 * Test book payment flow.
	 * 
	 * Create an item of type book, initializes it.
	 * Send it to payment delegate for payment and post payment processing.
	 */
	public void testBook() {
		try {
			System.out.println("\n\n\n\n");
			/** Payment example for Book **/
			Item item = new Book("ISBN-991", "Paulo Coelo", "Penguine Publisher");
			item.setItemName("The Alchemist");
			item.setPrice(123.00);
			paymentDelegate.pay(item);
		} catch (Throwable t) {
			log.error("An error occured during payment! Please try later.", t);
		}
	}
}
