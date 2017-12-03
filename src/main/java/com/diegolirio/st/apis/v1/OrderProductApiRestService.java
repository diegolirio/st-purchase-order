package com.diegolirio.st.apis.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolirio.st.domain.orm.OrderProduct;
import com.diegolirio.st.service.item.OrderProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping(OrderProductApiRestService.URL)
public class OrderProductApiRestService {

	public static final String URL = "/api/v1/item";
	
	@Autowired
	private ObjectMapper objectMapperPurchase;

	@Autowired
	private OrderProductService orderProductService;

	@GetMapping
	public ResponseEntity<?> findAll() throws JsonProcessingException {
		List<OrderProduct> list = this.orderProductService.findAll();
		return new ResponseEntity<String>(this.objectMapperPurchase.writeValueAsString(list) , HttpStatus.OK);
	}
	
	@GetMapping("/purchase/{purchaseOrderId}")
	public ResponseEntity<?> findByPurchaseOrderId(@PathVariable("purchaseOrderId") String purchaseOrderId) throws JsonProcessingException {
		List<OrderProduct> list = this.orderProductService.findByPurchaseOrderId(purchaseOrderId);
		return new ResponseEntity<String>(this.objectMapperPurchase.writeValueAsString(list) , HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody OrderProduct orderProduct) throws JsonProcessingException {
		orderProduct = this.orderProductService.save(orderProduct);
		return new ResponseEntity<String>(this.objectMapperPurchase.writeValueAsString(orderProduct), HttpStatus.OK);
	}	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) throws JsonProcessingException {
		this.orderProductService.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
}
