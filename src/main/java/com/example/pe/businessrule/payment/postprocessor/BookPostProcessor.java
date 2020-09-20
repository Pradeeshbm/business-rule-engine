package com.example.pe.businessrule.payment.postprocessor;

import com.example.pe.businessrule.model.Item;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookPostProcessor implements PaymentPostProcessor {

	@Override
	public void process(Item item) {
		log.info("create a duplicate packing slip for the royalty department.");
	}

}
