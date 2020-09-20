package com.example.pe.businessrule.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Laptop POJO
 * 
 * @author pradeesh.kumar
 */
@Data @AllArgsConstructor
public class Laptop extends PhysicalProduct {

	private String model;
}
