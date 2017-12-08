package com.diegolirio.st.resourcers;

import java.sql.Date;

import lombok.Data;

@Data
public class POMasterReport {
	
	private String number;
	
	private Date emissionDate;
	// sender
	private String cnpjSender, ieSender, nameSender, phoneSender, addressSender, 
				neighborhoodSender, citySender, stateSender, cepSender;
	
	// recipient
	private String nameRecipient, cnpjRecipient, addressRecipient, neighborhoodRecipient, 
				cepRecipient, cityRecipient, stateRecipient, ieRecipient, phone1Recipient, contactRecipient;
	// transport
	private String nameShippingCompany, phoneShippingCompany;
	// ??
	private String representative, paymentConditions, remark, addressNumberSender, addressShippingCompany, addressNumberShippingCompany;
	private int addressNumberRecipient;
	
}