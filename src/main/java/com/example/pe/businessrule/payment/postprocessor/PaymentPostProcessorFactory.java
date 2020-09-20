package com.example.pe.businessrule.payment.postprocessor;

import com.example.pe.businessrule.model.Book;
import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.model.Membership;
import com.example.pe.businessrule.model.Membership.MembershipStatus;
import com.example.pe.businessrule.model.PhysicalProduct;
import com.example.pe.businessrule.model.Video;

/**
 * A factory for creating PaymentPostProcessorChain object based on the item type.
 * 
 * @author pradeesh.kumar
 */
public final class PaymentPostProcessorFactory {
	
	/**
	 * Private constructor to avoid instantiation of factory class
	 */
	private PaymentPostProcessorFactory() {}
	
	/**
	 * Creates the the PostProcessor chain based on the item type. If item type
	 * doesn't match any concrete type, returns DefaultPostProcessor chain to avoid
	 * broken chain.
	 *
	 * @param item the item
	 * @return the post processor chain
	 */
	public static PostProcessorChain create(Item item) {
		if (item instanceof PhysicalProduct) {
			return createPhysicalProductChain(item);
		} else if (item instanceof Membership) {
			return createMembershipChain(item);
		} else if (item instanceof Video) {
			/** If it's a Video: Learning to Ski, generate ad**/
			return new PostProcessorChain(new VideoItemPostProcessor());
		}
		return new PostProcessorChain(new DefaultPostProcessor());
	}
	
	/**
	 * Creates a new PaymentPostProcessor for Physical products
	 *
	 * @param item the item
	 * @return the post processor chain
	 */
	public static PostProcessorChain createPhysicalProductChain(Item item) {
		/** If it's a physical product, then Packing Receipt **/
		PostProcessorChain packingChain = new PostProcessorChain(new PackingSlipPostProcessor());
		PostProcessorChain commissionChain = new PostProcessorChain(new CommisionPaymentPostProcessor());
		
		if (item instanceof Book) {
			/** If it's a book, generate packing slip and create duplicate slip for royalty department **/
			PostProcessorChain bookChain = new PostProcessorChain(new BookPostProcessor());
			bookChain.setNextChain(commissionChain);
			packingChain.setNextChain(bookChain);
		} else {
			packingChain.setNextChain(commissionChain);
		}
		return packingChain;
	}
	
	/**
	 * Creates a new PaymentPostProcessor object for Membership new/upgrade payment.
	 *
	 * @param item the item
	 * @return the post processor chain
	 */
	public static PostProcessorChain createMembershipChain(Item item) {
		/** If it's a new membership, activate the membership, otherwise upgrade.
		 * Send email to the customer for both the case **/
		PostProcessorChain emailChain = new PostProcessorChain(new ActivationEmailPostProcessor());
		if (((Membership) item).getStatus() == MembershipStatus.NEW) {
			return new PostProcessorChain(new MembershipActivationPostProcessor(), emailChain);
		} else {
			return new PostProcessorChain(new UpgradeMembershipPostProcessor(), emailChain);
		}
	}
}
