package com.palle.plant.pojo;

import lombok.Data;

@Data
public class ErrorResponse {

	private final String errorCode;
	private final String errorMessage;

	public ErrorResponse(String errorCode, String errrorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errrorMessage;
	}

}
