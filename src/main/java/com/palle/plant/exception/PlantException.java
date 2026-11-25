package com.palle.plant.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PlantException extends RuntimeException{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8211169771416124445L;
	
	private final String errorCode ;
	private final String errorMessage ;
	private final HttpStatus httpStatus ;
	
	public PlantException(
			String errorCode,
			String errorMessage, 
			HttpStatus httpStatus) {
		
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}
	
	

}
