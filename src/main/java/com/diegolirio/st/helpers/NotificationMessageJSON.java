package com.diegolirio.st.helpers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegolirio.st.notification.NotificationMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("NotificationMessageJSON")
public class NotificationMessageJSON implements JSONConvert {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public String toJSON(Object object) {
		try {
			return this.objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public NotificationMessage toObject(String json) {
		try {
			return this.objectMapper.readValue(json, NotificationMessage.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
