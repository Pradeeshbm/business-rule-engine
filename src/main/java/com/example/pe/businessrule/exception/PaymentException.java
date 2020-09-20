package com.example.pe.businessrule.exception;

/**
 * The Class PaymentException - to throw exception during payment.
 * 
 * @author pradeesh.kumar
 */
public class PaymentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new payment exception.
	 *
	 * @param msg the msg
	 */
	public PaymentException(String msg) {
		super(msg);
	}
}
