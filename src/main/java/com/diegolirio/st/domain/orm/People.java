package com.diegolirio.st.domain.orm;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class People {

	protected String cpfCnpj, name, email;

	protected boolean active;
	
	@JsonIgnore
	protected List<Address> addresses;
	
	@JsonIgnore
	protected List<Telephone> phones;
	
}
