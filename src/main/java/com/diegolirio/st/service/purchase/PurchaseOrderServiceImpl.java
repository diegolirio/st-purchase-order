package com.diegolirio.st.service.purchase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.domain.orm.StatusType;
import com.diegolirio.st.exceptions.PurchaseOrderCompletedException;


@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	private ActionsAfterCompleteService actionsAfterCompleteService;

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
		return this.purchaseOrderRepository.findOne(id);
	}

	@Override
	public PurchaseOrder complete(PurchaseOrder purchaseOrder) throws PurchaseOrderCompletedException {
		if(purchaseOrder.getStatus() != StatusType.PENDING) {
			throw new PurchaseOrderCompletedException("Para finalizar o pedido é preciso que o mesmo esteja com Status PENDENTE.");
		} 
		purchaseOrder.setStatus(StatusType.COMPLETED);
		purchaseOrder = this.save(purchaseOrder);
		this.actionsAfterCompleting(purchaseOrder);
		return purchaseOrder;
	}

	private void actionsAfterCompleting(PurchaseOrder purchaseOrder) {
		List<ActionCompleting> actions = new ArrayList<>();
		actions.add(new EmailPurchase(purchaseOrder));
		actions.add(new GenerateNF(purchaseOrder));
		this.actionsAfterCompleteService.executeActions(actions);		
	}

}
