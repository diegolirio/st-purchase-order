package com.diegolirio.st.notification;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmailNotification implements Notification {

	@Override
	public void send(NotificationMessage notificationMessage) {
		log.info(notificationMessage.toString());
		// TODO JavaMail
	}

}
