package com.diegolirio.st.domain.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection="address")
public class Address {

	@Id
	private String id;
	
	private String cep, publicPlace, neighborhood, city;
	
	private int number;
	
	private State state;
	
	private People people;
	
	private boolean active;
	
}
