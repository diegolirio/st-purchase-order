package com.diegolirio.st.jms;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.diegolirio.st.helpers.NotificationMessageJSON;
import com.diegolirio.st.notification.EmailNotification;
import com.diegolirio.st.notification.NotificationMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NotifyReceiverImpl implements NotifyReceiver {

	private CountDownLatch latch = new CountDownLatch(1);

	@Autowired
	private EmailNotification emailNotification;

	@Autowired
	private NotificationMessageJSON notifyMessageJSON;

	public CountDownLatch getLatch() {
		return latch;
	}

	@JmsListener(destination = "${destination.queue.notify}")
	public void receive(String message) {
		log.info("received message='{}'", message);
		// TODO NotificationFactory.getNotification(NotificationType.EMAIL);
		// this.emailNo.send();
		NotificationMessage notificationMessage = this.notifyMessageJSON.toObject(message);
		this.emailNotification.send(notificationMessage);
		latch.countDown();
	}
}
