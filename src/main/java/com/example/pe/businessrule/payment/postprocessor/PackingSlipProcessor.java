package com.example.pe.businessrule.payment.postprocessor;

import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.model.PhysicalProduct;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PackingSlipProcessor implements PaymentPostProcessor {

	@Override
	public void process(Item item) {
		PhysicalProduct book = (PhysicalProduct) item;
		log.info("Generating packing slip for the product: {}", item.getItemName());
		log.info("--------------PACKING SLIP--------------");
		log.info("Book Name: {}", item.getItemName());
		log.info("Price: {}", item.getPrice());
		log.info("Width: {}", book.getWidth());
		log.info("Height: {}", book.getHeight());
		log.info("Weight: {}", book.getWeight());
		log.info("--------------END OF SLIP--------------");
	}

}
