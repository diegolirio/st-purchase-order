package com.diegolirio.st.notification;

import java.util.Date;

import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.diegolirio.st.resources.Attachment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmailNotification implements Notification {

	@Autowired
	private JavaMailSender emailSender;
	
	@Value("${app.mail.from}")
	private String from;
	
	@Override
	public void send(NotificationMessage notificationMessage) {
		log.info(notificationMessage.toString());
		
		MimeMessage message = emailSender.createMimeMessage();
		try {
			message.setFrom(new InternetAddress(from));
			message.setSubject(notificationMessage.getSubject());
			message.setSentDate(new Date());
			
			MimeBodyPart attachment0 = new MimeBodyPart();
			attachment0.setContent(notificationMessage.getMessage(), "text/html; charset=UTF-8");
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(attachment0);
			message.setContent(multipart);
			
			for (String to : notificationMessage.getReceivers()) {
				message.addRecipient(RecipientType.TO, new InternetAddress(to));
			}
			
			for(Attachment att : notificationMessage.getAttachments()) {
				MimeBodyPart attachment1 = new MimeBodyPart();   
				attachment1.setDataHandler(new DataHandler(new ByteArrayDataSource(att.getFileBinary(), "text/pdf")));
				attachment1.setFileName(att.getName());
				multipart.addBodyPart(attachment1);
			}
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		emailSender.send(message);
	}
	

}
