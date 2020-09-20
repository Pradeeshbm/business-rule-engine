package com.example.pe.businessrule.payment.postprocessor;

import com.example.pe.businessrule.model.Item;

/**
 * The Class PostProcessorChain - responsible to execute payment post processing
 * single step unit in the chain.
 * Executes the next chain in the sequence serially after the current chain has been executed.
 * 
 * @author pradeesh.kumar
 */
public class PostProcessorChain {

	private PaymentPostProcessor postProcessor;
	private PostProcessorChain nextChain;
	
	/**
	 * Instantiates a new post processor chain.
	 *
	 * @param postProcessor the post processor
	 * @param nextChain the next chain
	 */
	public PostProcessorChain(PaymentPostProcessor postProcessor, PostProcessorChain nextChain) {
		if (postProcessor == null) {
			throw new NullPointerException("Post processor cannot be null!");
		}
		this.postProcessor = postProcessor;
		this.nextChain = nextChain;
	}
	
	/**
	 * Instantiates a new post processor chain.
	 *
	 * @param postProcessor the post processor
	 */
	public PostProcessorChain(PaymentPostProcessor postProcessor) {
		this(postProcessor, null);
	}
	
	/**
	 * Execute the current chain, next chain in the sequence will be executed once
	 * current chain is completed.
	 *
	 * @param item the item
	 */
	public void execute(Item item) {
		postProcessor.process(item);
		if (nextChain != null) {
			nextChain.execute(item);
		}
	}
	
	/**
	 * Sets the next chain.
	 *
	 * @param nextChain the new next chain
	 */
	public void setNextChain(PostProcessorChain nextChain) {
		this.nextChain = nextChain;
	}
}
