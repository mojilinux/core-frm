package com.lami.framework.common.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApplicationException extends RuntimeException {
	private String message = "";
	private int errorCode;

	public ApplicationException(String exceptionKey) {
		this.errorCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
		this.message = exceptionKey;
	}

	public ApplicationException(String exceptionKey, int errorCode) {
		this.errorCode = errorCode;
		this.message = exceptionKey;
		System.err.println(HttpStatus.valueOf(errorCode) + " : " + exceptionKey);
	}
}
