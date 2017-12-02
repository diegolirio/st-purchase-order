package com.diegolirio.st.service.purchase;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.domain.orm.StatusType;


@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

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

}
