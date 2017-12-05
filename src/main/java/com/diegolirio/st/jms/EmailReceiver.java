package com.diegolirio.st.jms;

import java.util.concurrent.CountDownLatch;

public interface EmailReceiver {

	CountDownLatch getLatch();
	
	void receive(String message);
	
}
