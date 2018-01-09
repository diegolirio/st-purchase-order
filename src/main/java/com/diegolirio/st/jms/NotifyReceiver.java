package com.diegolirio.st.jms;

import java.util.concurrent.CountDownLatch;

public interface NotifyReceiver {

	CountDownLatch getLatch();
	
	void receive(String message);
	
}
