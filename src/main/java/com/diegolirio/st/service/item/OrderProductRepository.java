package com.diegolirio.st.service.item;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.st.domain.orm.OrderProduct;
import com.diegolirio.st.domain.orm.PurchaseOrder;

@Repository
interface OrderProductRepository extends MongoRepository<OrderProduct, String> {

	List<OrderProduct> findByPurchaseOrder(PurchaseOrder purchaseOrder);

}
