package com.diegolirio.st.domain.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
@Document(collection="telephones")
public class Telephone {

	@Id
	private String id;
	
	private String contactType, number;
	
	private People people;

	private boolean active = true;
	
}
