package com.diegolirio.st.apis.v1;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolirio.st.domain.orm.PurchaseOrder;

@RestController
@RequestMapping(PurchaseOrderApiRestService.URL)
public class PurchaseOrderApiRestService {

	public static final String URL = "/api/v1/purchase";

	@GetMapping
	public List<PurchaseOrder> findAll() {
		return Arrays.asList(PurchaseOrder.builder().id("s514d15f1r58g1").createdDate(Calendar.getInstance()).build());
	}
	
}
