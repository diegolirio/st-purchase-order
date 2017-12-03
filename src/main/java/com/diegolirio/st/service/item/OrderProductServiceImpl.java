package com.diegolirio.st.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.st.domain.orm.OrderProduct;
import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.service.purchase.PurchaseOrderService;

@Service
public class OrderProductServiceImpl implements OrderProductService {

	@Autowired
	private OrderProductRepository orderProductRepository;
	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@Override
	public List<OrderProduct> findAll() {
		return this.orderProductRepository.findAll();
	}

	@Override
	public OrderProduct save(OrderProduct orderProduct) {
		return this.orderProductRepository.save(orderProduct);
	}

	@Override
	public List<OrderProduct> findByPurchaseOrderId(String id) {
		PurchaseOrder purchaseOrder = this.purchaseOrderService.findOne(id);
		return this.orderProductRepository.findByPurchaseOrder(purchaseOrder); 
	}

	@Override
	public void delete(String id) {
		this.orderProductRepository.delete(id);
	}

}
