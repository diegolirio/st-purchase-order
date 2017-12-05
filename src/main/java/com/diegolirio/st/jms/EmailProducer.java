package com.diegolirio.st.jms;

public interface EmailProducer {

	void send(String destination, String message);
	
}
