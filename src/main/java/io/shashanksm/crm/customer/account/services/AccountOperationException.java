package io.shashanksm.crm.customer.account.services;

public class AccountOperationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 400L;

	protected Long code;
	
	protected String message;
	
	protected String hint;

	public AccountOperationException(Long code, String message, String hint) {
		super(message);
		this.code = code;
		this.message = message;
		this.hint = hint;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}
	
}
