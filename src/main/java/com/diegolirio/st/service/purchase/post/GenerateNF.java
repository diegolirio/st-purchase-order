package com.diegolirio.st.service.purchase.post;

import org.springframework.stereotype.Component;

import com.diegolirio.st.domain.orm.PurchaseOrder;

import lombok.Getter;

@Component("GenerateNF")
public class GenerateNF implements ActionCompleting {

	@Getter
	private PurchaseOrder purchaseOrder;

	@Override
	public void execute() {
		System.out.println(purchaseOrder.getId() + " adicionado na fila para gerar NF");
	}

	@Override
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

}
