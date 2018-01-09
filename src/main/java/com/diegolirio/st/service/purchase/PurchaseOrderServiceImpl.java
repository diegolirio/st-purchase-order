package com.diegolirio.st.service.purchase;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.st.domain.orm.OrderProduct;
import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.domain.orm.StatusType;
import com.diegolirio.st.exceptions.PurchaseOrderIsNotPendingException;
import com.diegolirio.st.service.item.OrderProductService;
import com.diegolirio.st.service.purchase.post.ActionCompleting;
import com.diegolirio.st.service.purchase.post.ActionCompletingFactories;
import com.diegolirio.st.service.purchase.post.ActionsAfterCompleteService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service("purchaseOrderServiceImpl")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	private ActionsAfterCompleteService actionsAfterCompleteService;

	@Autowired
	private ActionCompletingFactories actionCompletingFactories;

	@Autowired
	private OrderProductService orderProductService;

	@Override
	public List<PurchaseOrder> findAll() {
		return (List<PurchaseOrder>) this.purchaseOrderRepository.findAll();
	}

	@Override
	public PurchaseOrder save(PurchaseOrder purchase) {
		if(StringUtils.isEmpty(purchase.getId())) {
			purchase.setCreatedDate(new Date());
			purchase.setStatus(StatusType.PENDING);
		}
		return this.purchaseOrderRepository.save(purchase);
	}

	@Override
	public PurchaseOrder findOne(String id) {
		//log.error("this.purchaseOrderRepository.findOne({})", id);
		//throw new RuntimeException("ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
		return this.purchaseOrderRepository.findOne(id);
	}

	@Override
	public PurchaseOrder complete(PurchaseOrder purchaseOrder) throws PurchaseOrderIsNotPendingException {
		if(purchaseOrder.getStatus() != StatusType.PENDING) {
			throw new PurchaseOrderIsNotPendingException();
		} 
		purchaseOrder.setStatus(StatusType.COMPLETED);
		List<OrderProduct> items = this.orderProductService.findByPurchaseOrderId(purchaseOrder.getId());
		purchaseOrder.setOrdersProducts(items);
		purchaseOrder = this.save(purchaseOrder);
		this.actionsAfterCompleting(purchaseOrder);
		return purchaseOrder;
	}

	private void actionsAfterCompleting(PurchaseOrder purchaseOrder) {
		List<ActionCompleting> actions  = this.actionCompletingFactories.getActions(purchaseOrder);
		this.actionsAfterCompleteService.executeActions(actions);		
	}

}
