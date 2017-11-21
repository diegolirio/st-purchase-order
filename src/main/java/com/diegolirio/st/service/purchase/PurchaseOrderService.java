package com.diegolirio.st.service.purchase;

import java.util.List;

import com.diegolirio.st.domain.orm.PurchaseOrder;

public interface PurchaseOrderService {

	List<PurchaseOrder> findAll();

}
