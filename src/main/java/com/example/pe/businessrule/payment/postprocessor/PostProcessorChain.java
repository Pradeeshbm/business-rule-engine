package com.example.pe.businessrule.payment.postprocessor;

import com.example.pe.businessrule.model.Item;

public class PostProcessorChain {

	private PaymentPostProcessor postProcessor;
	private PostProcessorChain nextChain;
	
	public PostProcessorChain(PaymentPostProcessor postProcessor, PostProcessorChain nextChain) {
		if (postProcessor == null) {
			throw new NullPointerException("Post processor cannot be null!");
		}
		this.postProcessor = postProcessor;
		this.nextChain = nextChain;
	}
	
	public PostProcessorChain(PaymentPostProcessor postProcessor) {
		this(postProcessor, null);
	}
	
	public void execute(Item item) {
		postProcessor.process(item);
		if (nextChain != null) {
			nextChain.execute(item);
		}
	}
	
	public void setNextChain(PostProcessorChain nextChain) {
		this.nextChain = nextChain;
	}
}
