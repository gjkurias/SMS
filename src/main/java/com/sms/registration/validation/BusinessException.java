package com.sms.registration.validation;

public class BusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  int code;
	public BusinessException(int code) {
		super();
		this.code = code;
	}
	public int getCode() {
		return this.code;
	}
}
