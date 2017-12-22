package org.isgh.iprede.model.response;

import org.isgh.iprede.exception.RestException;
import org.isgh.iprede.exception.RestExceptionCode;

public final class ErrorResponse extends AbstractResponse {
	
	private final String code;
	private final String error;

	public ErrorResponse(RestException ex) {
		this(ex.getExceptionCode(), ex.getMessage());
	}

   public ErrorResponse(RestExceptionCode exceptionCode) {
        this(exceptionCode.name(), exceptionCode.getError());
    }

	public ErrorResponse(RestExceptionCode exceptionCode, String error) {
	    this(exceptionCode.name(), error);
	}

	public ErrorResponse(String code, String error) {
		this.code = code;
		this.error = error;
	}

	public String getCode() {
		return code;
	}

	public String getError() {
		return error;
	}

}
