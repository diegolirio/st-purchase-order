package com.diegolirio.st.domain.orm;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class People {

	private String cpfCnpj, name, email;

	private boolean active;
	
	@JsonIgnore
	private List<Address> addresses;
	
	@JsonIgnore
	private List<Telephone> phones;
	
}
