package com.example.pe.businessrule.payment.postprocessor;

import java.time.LocalDate;

import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.model.Membership;
import com.example.pe.businessrule.model.Membership.MembershipStatus;
import com.example.pe.businessrule.repository.MembershipRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Membership activation processor
 * 
 * @author pradeesh.kumar
 */
@Slf4j
public class MembershipActivationPostProcessor implements PaymentPostProcessor {
	
	private MembershipRepository repo;
	
	public MembershipActivationPostProcessor() {
		this.repo = MembershipRepository.get();
	}

	/**
	 * Activates the membership for next 6 months
	 *
	 * @param item the membership
	 */
	@Override
	public void process(Item item) {
		Membership m = (Membership) item;
		log.info("Activating membership for {}", m.getItemName());
		m.setSubscriptionStartDate(LocalDate.now());
		m.setSubscriptionEndData(LocalDate.now().plusMonths(6));
		m.setStatus(MembershipStatus.ACTIVE);
		repo.update(m);
		log.info("Membership has been activated till: {}", m.getSubscriptionEndData());
	}

}
