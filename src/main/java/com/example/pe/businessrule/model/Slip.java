package com.example.pe.businessrule.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * Payment receipt. Made Cloneable in order clone the receipt for additional
 * processors.
 * 
 * @author pradeesh.kumar
 */
@Data
public class Slip implements Cloneable {

	private List<String> lineItems;
	
	@Override
	public Slip clone() {
		Slip cloned;
		try {
			cloned = (Slip) super.clone();
		} catch (CloneNotSupportedException e) {
			cloned = new Slip();
		}
		cloned.setLineItems(new ArrayList<>(this.lineItems));
		return cloned;
	}
}
