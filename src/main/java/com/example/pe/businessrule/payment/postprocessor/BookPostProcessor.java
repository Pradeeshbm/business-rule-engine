package com.example.pe.businessrule.payment.postprocessor;

import com.example.pe.businessrule.model.Book;
import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.model.Slip;

import lombok.extern.slf4j.Slf4j;

/**
 * Creates a duplicate packing slip for the royalty department.
 * 
 * @author pradeesh.kumar
 */
@Slf4j
public class BookPostProcessor implements PaymentPostProcessor {

	/**
	 * Creates a duplicate packing slip for the royalty department.
	 *
	 * @param item the item
	 */
	@Override
	public void process(Item item) {
		log.info("Create a duplicate packing slip for the royalty department for the book: {}", item.getItemName());
		Book book = (Book) item;
		Slip clonedSlip = book.getSlip().clone();
		sendSlipToRoyaltyDept(book, clonedSlip);
	}
	
	/**
	 * Sends slip to Royalty dept.
	 *
	 * @param book the book
	 * @param copyOfSlip the copy of slip
	 */
	private void sendSlipToRoyaltyDept(Book book, Slip copyOfSlip) {
		log.info("Sending the copy of slip to Royalty dept");
	}

}
