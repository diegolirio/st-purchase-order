package com.diegolirio.st.apis.v1;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.service.purchase.PurchaseOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping(PurchaseOrderApiRestService.URL)
public class PurchaseOrderApiRestService {

	public static final String URL = "/api/v1/purchase";
	
	@Autowired
	private ObjectMapper objectMapperPurchase;

	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@GetMapping
	public ResponseEntity<?> findAll() throws JsonProcessingException {
		List<PurchaseOrder> list = this.purchaseOrderService.findAll();
		return new ResponseEntity<String>(this.objectMapperPurchase.writeValueAsString(list) , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@PathVariable("id") String id) {
		return new ResponseEntity<PurchaseOrder>(this.purchaseOrderService.findOne(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody PurchaseOrder purchaseOrder) throws JsonProcessingException {
		System.out.println("TF -> " + purchaseOrder.getTypeFreight());
		PurchaseOrder po = this.purchaseOrderService.save(purchaseOrder);
		return new ResponseEntity<String>(this.objectMapperPurchase.writeValueAsString(po) , HttpStatus.OK);
	}	
	
}
