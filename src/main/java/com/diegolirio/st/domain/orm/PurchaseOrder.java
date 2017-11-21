package com.diegolirio.st.domain.orm;

import java.util.Calendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection="purchaseorder")
public class PurchaseOrder {

	@Id
	private String id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar createdDate;
	
	private Address customerAddressSender, customerAddressRecipient, customerAddressShippingCompany;
	
	private String phoneSender, phoneRecipient, pohoneShippingCompany, contactRecipient, paymentsTerms, remark, representative;
	
	private char typeFreight;
	
	private StatusType status;
	
}
