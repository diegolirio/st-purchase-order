package com.diegolirio.st.service.purchase;

import com.diegolirio.st.domain.orm.PurchaseOrder;

import lombok.Getter;

public class GenerateNF implements ActionCompleting {

	@Getter
	private PurchaseOrder purchaseOrder;

	public GenerateNF(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@Override
	public void execute() {
		System.out.println(purchaseOrder.getId() + " adicionado na fila para gerar NF");
	}

}
