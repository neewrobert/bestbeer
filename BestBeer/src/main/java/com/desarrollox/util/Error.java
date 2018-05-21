package com.desarrollox.util;

public enum Error {

	EMAIL_INVALID			(1, "Email Iválido"), 
	PASSWORD_NOT_MATCH		(2, "Senhas não conferem "),
	USER_NOT_FOUND          (3, "Senha ou Login inválidos");

	private int errorCode;
	private String message;

	private Error(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
