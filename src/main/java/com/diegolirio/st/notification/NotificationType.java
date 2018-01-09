package com.diegolirio.st.notification;

import lombok.Getter;

public enum NotificationType {
	
	EMAIL("com.diegolirio.st.notification.EmailNotification"),
	SMS(null),
	PUSH_NOTIFICATION(null);

	//private static Map<String, Notification> flyweigth;
	//static {
	//	flyweigth = new HashMap<>();
	//	flyweigth.put("email", new EmailNotification());
	//	flyweigth.put("sms", null);
	//	flyweigth.put("push", null);
	//}
	
	@Getter
	private String rule;

	NotificationType(String rule) {
		this.rule = rule;
	}
	
}
