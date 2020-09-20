package com.example.pe.businessrule.model;

import lombok.Data;

/**
 * An abstract Physical Product
 * 
 * @author pradeesh.kumar
 */
@Data
public abstract class PhysicalProduct extends Item {

	private int height;
	private int width;
	private int weight;
}
