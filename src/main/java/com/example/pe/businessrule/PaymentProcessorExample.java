package com.example.pe.businessrule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pe.businessrule.model.Book;
import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.payment.PaymentDelegate;

@Component
public class PaymentProcessorExample {

	@Autowired
	private PaymentDelegate paymentDelegate;
	
	public void test() {
		/** Payment example for Book **/
		Item item = new Book("ISBN-991", "Paulo Coelo", "Penguine Publisher");
		item.setItemName("The Alchemist");
		item.setPrice(123.00);
		paymentDelegate.pay(item);
	}
}
