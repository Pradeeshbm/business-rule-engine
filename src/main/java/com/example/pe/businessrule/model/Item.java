package com.example.pe.businessrule.model;

import lombok.Data;

/**
 * An abstract item
 * 
 * @author pradeesh.kumar
 */
@Data
public abstract class Item {

	private int userId;
	protected String itemName;
	protected double price;
	protected Slip slip;
}
