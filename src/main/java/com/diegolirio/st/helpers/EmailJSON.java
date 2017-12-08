package com.diegolirio.st.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegolirio.st.resources.Email;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("EmailJSON")
public class EmailJSON implements JSONConvert {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public String toJSON(Email email) {
		try {
			return this.objectMapper.writeValueAsString(email);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
