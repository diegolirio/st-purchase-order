package com.diegolirio.st.service.purchase.post;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.helpers.JSONConvert;
import com.diegolirio.st.jms.NotifyProducer;
import com.diegolirio.st.notification.NotificationMessage;
import com.diegolirio.st.notification.NotificationType;
import com.diegolirio.st.resources.Attachment;
import com.diegolirio.st.service.purchase.file.PurchaseFile;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("NotifyPurchase")
public class NotifyPurchase implements ActionCompleting {

	@Value("${destination.queue.notify}")
	private String destination;

	@Getter @Setter
	private PurchaseOrder purchaseOrder;
	
	@Autowired
	private NotifyProducer notifyProducer;

	@Autowired @Qualifier("NotificationMessageJSON")
	private JSONConvert jsonConvert;
	
	@Autowired 
	@Qualifier("PurchaseFilePDFBase64")
	private PurchaseFile purchaseFile;

	@Override
	public void execute() {
		log.info(purchaseOrder.getId() + " adicionado na fila de Notificação");
		NotificationMessage notificationMessage = this.builder(purchaseOrder);
		//Email email = this.builder(this.purchaseOrder);
		this.notifyProducer.send(destination, this.jsonConvert.toJSON(notificationMessage));
	}

//	private Email builder(PurchaseOrder purchaseOrder) {
//		List<String> to = Arrays.asList(purchaseOrder.getRecipientEmail());
//		List<String> cc = Arrays.asList(purchaseOrder.getSenderEmail());
//		String purchaseAttach = purchaseFile.toFile(purchaseOrder);
//		Attachment attach = new Attachment();
//		attach.setFile(purchaseAttach);
//		attach.setName("Pedido-"+purchaseOrder.getId()); 
//		List<Attachment> attachments = Arrays.asList(attach); 
//		return Email.builder().subject(String.format("Pedido %s", purchaseOrder.getId()))
//							  .body("Segue pedido em anexo")
//							  .to(to)
//							  .cc(cc)
//							  .attachments(attachments)
//							  .build();
//	}

	private NotificationMessage builder(PurchaseOrder purchaseOrder) {
		List<String> to = Arrays.asList(purchaseOrder.getRecipientEmail());
		List<String> cc = Arrays.asList(purchaseOrder.getSenderEmail());
		String purchaseAttach = purchaseFile.toFile(purchaseOrder);
		Attachment attach = new Attachment();
		attach.setFile(purchaseAttach);
		attach.setName("Pedido-"+purchaseOrder.getId()); 
		List<Attachment> attachments = Arrays.asList(attach); 
		NotificationMessage notificationMessage = new NotificationMessage();
		notificationMessage.setAttachments(attachments);
		notificationMessage.setCc(cc);
		notificationMessage.setMessage("Em anexo");
		notificationMessage.setNotificationType(NotificationType.EMAIL);
		notificationMessage.setReceivers(to);
		notificationMessage.setSubject(String.format("Pedido %s", purchaseOrder.getId()));
		return notificationMessage;
	}
	
	
	
	
}