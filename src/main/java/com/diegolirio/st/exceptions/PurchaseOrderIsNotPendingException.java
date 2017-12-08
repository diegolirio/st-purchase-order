package com.diegolirio.st.exceptions;

import lombok.Getter;

public class PurchaseOrderIsNotPendingException extends Exception {

	private static final long serialVersionUID = 1L;

	@Getter
	private String message;
	
	public PurchaseOrderIsNotPendingException() {
		this.message = "Para finalizar o pedido é preciso que o mesmo esteja com Status PENDENTE.";
	}


}
