package com.diegolirio.st.service.item;

import java.util.List;

import com.diegolirio.st.domain.orm.OrderProduct;

public interface OrderProductService {

	List<OrderProduct> findAll();

	OrderProduct save(OrderProduct orderProduct);

	List<OrderProduct> findByPurchaseOrderId(String id);

	void delete(String id);

}
