package com.example.pe.businessrule.repository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class UserProfileRepository.
 * 
 * @author pradeesh.kumar
 */
@Repository
@Slf4j
public class UserProfileRepository implements InitializingBean {
	
	private static UserProfileRepository instance;
	
	/**
	 * Gets the user email id.
	 *
	 * @param membershipId the membership id
	 * @return the user email id
	 */
	public String getUserEmailId(long membershipId) {
		log.info("Retrieving user's email id from db for the membership id: {}", membershipId);
		return "example@example.com";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		instance = new UserProfileRepository();
	}
	
	public static UserProfileRepository get() {
		return instance;
	}

}
