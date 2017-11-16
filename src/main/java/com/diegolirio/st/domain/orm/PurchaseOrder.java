package com.diegolirio.st.domain.orm;

import java.util.Calendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection="purchaseorder")
public class PurchaseOrder {

	@Id
	private String id;
	
	private Calendar createdDate;
	
}
