package com.diegolirio.st.service.purchase.file;

import com.diegolirio.st.domain.orm.PurchaseOrder;

public interface PurchaseFile {

	String toFile(PurchaseOrder purchaseOrder);

}
