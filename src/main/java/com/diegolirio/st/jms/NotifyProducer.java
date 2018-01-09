package com.diegolirio.st.jms;

public interface NotifyProducer {

	void send(String destination, String message);
	
}
