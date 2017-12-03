package com.diegolirio.st.exceptions;

import lombok.Getter;

public class PurchaseOrderCompletedException extends Exception {

	private static final long serialVersionUID = 1L;

	@Getter
	private String message;

	public PurchaseOrderCompletedException(String message) {
		this.message = message;
	}


}
