package com.diegolirio.st.domain.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
@Document(collection="product")
public class Product {

	@Id
	private String id;
	private String code;
	private String description;
	private double valueUnit;
	
	
}
