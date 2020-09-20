package com.example.pe.businessrule.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Membership extends Item {

	private long membershipId;
	private MembershipStatus status;
	private LocalDate subscriptionStartDate;
	private LocalDate subscriptionEndData;
	
	public static enum MembershipStatus {
		NEW, UPGRADE;
	}
}
