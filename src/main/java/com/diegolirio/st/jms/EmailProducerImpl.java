package com.diegolirio.st.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmailProducerImpl implements EmailProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailProducerImpl.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(String destination, String message) {
		LOGGER.info("sending message='{}' to destination='{}'", message, destination);
		jmsTemplate.convertAndSend(destination, message);
	}

}
