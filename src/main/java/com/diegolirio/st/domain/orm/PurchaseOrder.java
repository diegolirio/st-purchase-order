package com.diegolirio.st.domain.orm;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.diegolirio.st.types.TypeFreight;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=PurchaseOrder.BOOLEAN)
@ToString
@Document(collection="purchaseorder")
public class PurchaseOrder {

	static final boolean BOOLEAN = true;

	@Id
	private String id;
	
	@Setter
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date createdDate;
	
	private Address customerAddressSender, customerAddressRecipient, customerAddressShippingCompany;
	
	private String phoneSender, phoneRecipient, phoneShippingCompany, contactRecipient, paymentsTerms, remark, representative;
	
	private TypeFreight typeFreight;
	
	@Setter
	private StatusType status;
	
	@Setter
	private Boolean sendToGenerateNF;
	
	@Setter
	private List<OrderProduct> ordersProducts;

	public String getRecipientEmail() {
		return this.customerAddressRecipient.getPeopleEmail();
	}
 
	public String getSenderEmail() {
		return this.customerAddressSender.getPeopleEmail();
	}
	
}
