package com.diegolirio.st.service.purchase.post;

import com.diegolirio.st.domain.orm.PurchaseOrder;

public interface ActionCompleting {

	void execute();
	
	void setPurchaseOrder(PurchaseOrder purchaseOrder);
	
}
