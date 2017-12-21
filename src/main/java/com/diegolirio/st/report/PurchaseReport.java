package com.diegolirio.st.report;

import com.diegolirio.st.domain.orm.PurchaseOrder;

public interface PurchaseReport {

	byte[] generate(PurchaseOrder purchaseOrder);
	
}
