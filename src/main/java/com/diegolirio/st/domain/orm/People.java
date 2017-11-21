package com.diegolirio.st.domain.orm;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection="people")
public class People {

	@Id
	private String id;
	
	private String cpfCnpj, name, email;

	private boolean active;
	
	@JsonIgnore
	private List<Address> addresses;
	
	@JsonIgnore
	private List<Telephone> phones;
	
}
