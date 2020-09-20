package com.example.pe.businessrule.model;

import lombok.Data;

@Data
public class Payment {

	private int recieptNumber;
	private Item item;
	private double amount;
}
