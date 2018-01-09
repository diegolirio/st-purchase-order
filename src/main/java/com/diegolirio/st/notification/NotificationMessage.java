package com.diegolirio.st.notification;

import java.util.List;

import com.diegolirio.st.resources.Attachment;

import groovy.transform.ToString;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NotificationMessage {

	private String subject, message;
	private List<String> receivers, cc;
	private List<Attachment> attachments;	
	private NotificationType notificationType;
	
}
