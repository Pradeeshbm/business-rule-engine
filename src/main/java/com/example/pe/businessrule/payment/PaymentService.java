package com.example.pe.businessrule.payment;

import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.payment.postprocessor.PostProcessorChain;

public interface PaymentService {
	
	void pay(Item item, PostProcessorChain postProcessorChain);
}
