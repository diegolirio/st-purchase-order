package com.diegolirio.st.service.purchase.post;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.diegolirio.st.domain.orm.PurchaseOrder;

@Component
public class ActionCompletingFactories {

	@Autowired @Qualifier("EmailPurchase")
	private ActionCompleting email;
	
	@Autowired @Qualifier("GenerateNF")
	private ActionCompleting generateNF;
	
	
	public List<ActionCompleting> getActions(PurchaseOrder purchaseOrder) {
		email.setPurchaseOrder(purchaseOrder);
		generateNF.setPurchaseOrder(purchaseOrder);
		return Arrays.asList(email, generateNF);
	}

}
