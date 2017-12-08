package com.diegolirio.st.domain.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
@Document(collection="address")
public class Address {

	@Id
	private String id;
	
	private String cep, publicPlace, neighborhood, city;
	
	private int number;
	
	private State state;
	
	private People people;
	
	private boolean active;

	public String getPeopleEmail() {
		return this.people.getEmail();
	}
	
}
