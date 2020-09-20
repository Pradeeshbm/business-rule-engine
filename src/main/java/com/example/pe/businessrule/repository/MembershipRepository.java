package com.example.pe.businessrule.repository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import com.example.pe.businessrule.model.Membership;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class MembershipRepository.
 * 
 * @author pradeesh.kumar
 */
@Repository
@Slf4j
public class MembershipRepository implements InitializingBean {
	
	private static MembershipRepository instance;
	
	/**
	 * Update the membership.
	 */
	public void update(Membership membership) {
		log.info("Updating membership in db. Id: {}", membership.getMembershipId());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		instance = new MembershipRepository();
	}
	
	public static MembershipRepository get() {
		return instance;
	}
}
