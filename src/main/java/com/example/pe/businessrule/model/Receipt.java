package com.example.pe.businessrule.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Receipt implements Cloneable {

	private List<String> lineItems;
	
	@Override
	public Receipt clone() {
		Receipt cloned = this.clone();
		cloned.setLineItems(new ArrayList<>(this.lineItems));
		return cloned;
	}
}
