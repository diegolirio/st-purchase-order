package com.diegolirio.st.service.purchase;

import java.util.List;

import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.exceptions.PurchaseOrderIsNotPendingException;

public interface PurchaseOrderService {

	List<PurchaseOrder> findAll();

	PurchaseOrder save(PurchaseOrder purchase);

	PurchaseOrder findOne(String id);

	PurchaseOrder complete(PurchaseOrder purchaseOrder) throws PurchaseOrderIsNotPendingException;

}
