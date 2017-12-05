package com.diegolirio.st.service.purchase.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.jms.EmailProducer;

import lombok.Getter;
import lombok.Setter;

@Component("EmailPurchase")
public class EmailPurchase implements ActionCompleting {

	@Getter @Setter
	private PurchaseOrder purchaseOrder;
	
	@Autowired
	private EmailProducer emailProducer;
	
	@Value("${destination.queue.email}")
	private String destination;

	@Override
	public void execute() {
		System.out.println(purchaseOrder.getId() + " adicionado na fila de email");
		this.emailProducer.send(destination, String.format("Email do pedido %s adicionado na Fila ", purchaseOrder.getId())); 
	}

}
