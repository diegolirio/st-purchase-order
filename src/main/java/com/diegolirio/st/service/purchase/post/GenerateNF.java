package com.diegolirio.st.service.purchase.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.service.purchase.PurchaseOrderService;

import lombok.Getter;

@Component("GenerateNF")
public class GenerateNF implements ActionCompleting {

	@Getter
	private PurchaseOrder purchaseOrder;
	
	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@Override
	public void execute() {
		System.out.println(purchaseOrder.getId() + " adicionado na fila para gerar NF");
		this.purchaseOrder.setSendToGenerateNF(true);
		this.purchaseOrderService.save(this.purchaseOrder);
	}

	@Override
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

}
