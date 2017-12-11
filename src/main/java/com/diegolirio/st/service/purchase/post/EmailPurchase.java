package com.diegolirio.st.service.purchase.post;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.helpers.JSONConvert;
import com.diegolirio.st.jms.EmailProducer;
import com.diegolirio.st.resources.Attachment;
import com.diegolirio.st.resources.Email;
import com.diegolirio.st.service.purchase.file.PurchaseFile;

import lombok.Getter;
import lombok.Setter;

@Component("EmailPurchase")
public class EmailPurchase implements ActionCompleting {

	@Value("${destination.queue.email}")
	private String destination;

	@Getter @Setter
	private PurchaseOrder purchaseOrder;
	
	@Autowired
	private EmailProducer emailProducer;

	@Autowired @Qualifier("EmailJSON")
	private JSONConvert jsonConvert;
	
	@Autowired 
	@Qualifier("PurchaseFilePDFBase64")
	private PurchaseFile purchaseFile;

	@Override
	public void execute() {
		System.out.println(purchaseOrder.getId() + " adicionado na fila de email");
		Email email = this.builder(this.purchaseOrder);
		this.emailProducer.send(destination, this.jsonConvert.toJSON(email));
	}

	private Email builder(PurchaseOrder purchaseOrder) {
		List<String> to = Arrays.asList(purchaseOrder.getRecipientEmail());
		List<String> cc = Arrays.asList(purchaseOrder.getSenderEmail());
		String purchaseAttach = purchaseFile.toFile(purchaseOrder);
		Attachment attach = new Attachment();
		attach.setFile(purchaseAttach);
		attach.setName("Pedido-"+purchaseOrder.getId()); 
		List<Attachment> attachments = Arrays.asList(attach); 
		return Email.builder().subject(String.format("Pedido %s", purchaseOrder.getId()))
							  .body("Segue pedido em anexo")
							  .to(to)
							  .cc(cc)
							  .attachments(attachments)
							  .build();
	}
	
	
	
}