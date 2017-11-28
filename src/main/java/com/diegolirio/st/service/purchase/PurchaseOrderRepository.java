package com.diegolirio.st.service.purchase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.st.domain.orm.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, String> {

}
