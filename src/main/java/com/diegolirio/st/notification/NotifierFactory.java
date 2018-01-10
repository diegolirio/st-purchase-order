package com.diegolirio.st.notification;

public class NotifierFactory {

	public static Notifier getNotifier(NotificationType notificationType) {
		String rule = notificationType.getRule();
		try {
			Class<?> clazz = Class.forName(rule);
			return (Notifier) clazz.newInstance();		
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e); 
		}
	}

}
