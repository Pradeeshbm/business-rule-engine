package com.example.pe.businessrule.payment.postprocessor;

import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.model.Membership;
import com.example.pe.businessrule.repository.UserProfileRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Sends activation email once membership is activated/upgraded
 * 
 * @author pradeesh.kumar
 */
@Slf4j
public class ActivationEmailPostProcessor implements PaymentPostProcessor {
	
	private UserProfileRepository profileRepo;
	
	public ActivationEmailPostProcessor() {
		profileRepo = UserProfileRepository.get();
	}

	/**
	 * Sends activation email once membership is activated/upgraded
	 *
	 * @param item the item
	 */
	@Override
	public void process(Item item) {
		Membership m = (Membership) item;
		String userEmail = profileRepo.getUserEmailId(m.getMembershipId());
		log.info("Email id retrieved from db: {}", userEmail);
		sendEmail(userEmail, m);
	}

	private void sendEmail(String userEmail, Membership m) {
		String subject = "Congrats Membership Activated!!!";
		String body = "Your membership has been activated! till" + m.getSubscriptionEndData();
		log.info("Sending email with subject: {} and body: {}", subject, body);
		log.info("Email has been sent.");
	}

}
