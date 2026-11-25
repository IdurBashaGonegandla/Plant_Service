package com.palle.plant.constant;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {
	
	GENERIC_ERROR("40000", "Unable to process the request. Please try again later."),
	INVALID_QUANTITY("40001", "Invalid quantity. Provide 1 or above"), 
	UNABLE_TO_CONNECT_TO_PLANT("40002", "Unable to connect to plant"),
	NO_PLANT_AVAILABLE("40004", "No plant available");
	
	private final String errorCode;
	private final String errorMessage;
	
	ErrorCodeEnum(String errorCode,
			String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
