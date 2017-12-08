package com.diegolirio.st.resources;

import com.diegolirio.st.domain.orm.OrderProduct;
import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.resourcers.CustomerResource;
import com.diegolirio.st.resourcers.POMasterReport;

import lombok.Data;

@Data
public class POReportDetail {

	private POMasterReport po;
	private ProductResource product;
	private double amount;
	private double valueUnit; 
	
	public POReportDetail(OrderProduct orderProduct, CustomerResource sender, CustomerResource recipient) {
		PurchaseOrder purchaseOrder = orderProduct.getPurchaseOrder();
		po = new POMasterReport();
		po.setNumber(purchaseOrder.getId());
//		po.setEmissionDate(purchaseOrder.getEmissionDate());
//		po.setPaymentConditions(purchaseOrder.getCondicaoPagamento());
//		po.setRemark(purchaseOrder.getRemark());
//		po.setRepresentative(purchaseOrder.getRepresentative());
//		// sender
//		po.setNameSender(sender.getName());
//		po.setCnpjSender(sender.getCpfCnpj());
//		po.setIeSender(sender.getSignUpState());
//		po.setAddressSender(purchaseOrder.getCustomerAddressSender().getPublicPlace());
//		po.setAddressNumberSender(purchaseOrder.getCustomerAddressSender().getNumber());
//		po.setNeighborhoodSender(purchaseOrder.getCustomerAddressSender().getNeighborhood());
//		po.setCitySender(purchaseOrder.getCustomerAddressSender().getCity());
//		po.setStateSender(purchaseOrder.getCustomerAddressSender().getState().getAbbreviation());
//		po.setCepSender(purchaseOrder.getCustomerAddressSender().getCep());
//
//		po.setPhoneSender(purchaseOrder.getPhoneSender());
//		// recipient
//		po.setNameRecipient(recipient.getName());
//		po.setCnpjRecipient(recipient.getCpfCnpj());
//		po.setIeRecipient(recipient.getSignUpState());
//		po.setAddressRecipient(purchaseOrder.getCustomerAddressRecipient().getPublicPlace());
//		po.setAddressNumberRecipient(purchaseOrder.getCustomerAddressRecipient().getNumber());
//		po.setNeighborhoodRecipient(purchaseOrder.getCustomerAddressRecipient().getNeighborhood());
//		po.setCityRecipient(purchaseOrder.getCustomerAddressRecipient().getCity());
//		po.setStateRecipient(purchaseOrder.getCustomerAddressRecipient().getState().getAbbreviation());
//		po.setCepRecipient(purchaseOrder.getCustomerAddressRecipient().getCep());
//		po.setPhone1Recipient(purchaseOrder.getPhoneRecipient());
//		po.setContactRecipient(purchaseOrder.getContactRecipient());
//		po.setNameShippingCompany(purchaseOrder.getCustomerAddressShippingCompany().getPeople().getName());
//		po.setPhoneShippingCompany(purchaseOrder.getPhoneShippingCompany());
//		po.setAddressShippingCompany(purchaseOrder.getCustomerAddressShippingCompany().getPublicPlace());
//		po.setAddressNumberShippingCompany(purchaseOrder.getCustomerAddressShippingCompany().getNumber());
//		
//		// produ
//		product = ordersProducts.getProduct();
//		amount = ordersProducts.getAmount();
//		valueUnit = ordersProducts.getValueUnit();
	}	
	
}