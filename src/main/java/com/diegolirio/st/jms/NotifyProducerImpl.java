package com.diegolirio.st.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NotifyProducerImpl implements NotifyProducer {

	
	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(String destination, String message) {
		log.info("sending message='{}' to destination='{}'", message, destination);
		jmsTemplate.convertAndSend(destination, message);
	}

}
