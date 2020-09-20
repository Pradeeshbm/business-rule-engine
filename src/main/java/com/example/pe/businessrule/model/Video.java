package com.example.pe.businessrule.model;

import lombok.Data;

/**
 * Video POJO
 * 
 * @author pradeesh.kumar
 */
@Data
public class Video extends Item {

	private String url;
	private int duration;
}
