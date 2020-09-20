package com.example.pe.businessrule.model;

import lombok.Data;

@Data
public class PhysicalProduct extends Item {

	private int height;
	private int width;
	private int weight;
}
