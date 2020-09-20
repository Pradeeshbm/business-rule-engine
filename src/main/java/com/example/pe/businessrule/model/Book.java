package com.example.pe.businessrule.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Book POJO
 * 
 * @author pradeesh.kumar
 */
@Data @AllArgsConstructor
public class Book extends PhysicalProduct {

	private String isbnNumber;
	private String author;
	private String publisher;
}
