package com.diegolirio.st.domain.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
@Document(collection="item")
public class OrderProduct {

	@Id
	private String id;
	
	private Product product;
	
	private PurchaseOrder purchaseOrder;
	
    public double valueUnit;
    
	public int amount;

}
