package com.example.pe.businessrule.model;

import lombok.Data;

@Data
public abstract class Item {

	protected String itemName;
	protected double price;
	protected Receipt reciept;
}
