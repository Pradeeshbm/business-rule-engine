package com.example.pe.businessrule.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Book extends Item {

	private String isbnNumber;
	private String author;
	private String publisher;
}
