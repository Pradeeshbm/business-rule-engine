package com.example.pe.businessrule.model;

import lombok.Data;

@Data
public abstract class PhysicalProduct extends Item {

	private int height;
	private int width;
	private int weight;
}
