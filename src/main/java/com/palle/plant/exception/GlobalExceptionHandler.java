package com.palle.plant.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.palle.plant.constant.ErrorCodeEnum;
import com.palle.plant.pojo.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult()
	          .getFieldErrors()
	          .forEach(error ->
	            errors.put(error.getField(), error.getDefaultMessage())
	          );
	        
	        return ResponseEntity.badRequest().body(errors);
//	        return errors;
	    }
	    
		@ExceptionHandler(PlantException.class)
		public ResponseEntity<ErrorResponse> handlePlantException(PlantException ex) {
			log.info("Handling plant exception: {}", ex.getMessage(), ex);

			ErrorResponse errorResponse = new ErrorResponse(
					ex.getErrorCode(),
					ex.getErrorMessage());

			log.info("ErrorResponse: {}", errorResponse);
			return new ResponseEntity<>(errorResponse, ex.getHttpStatus());

		}
		
		@ExceptionHandler(Exception.class)
		public ResponseEntity<ErrorResponse> handleException(Exception ex) {
			log.info("Handling plant exception: {}", ex.getMessage(), ex);

			ErrorResponse errorResponse = new ErrorResponse(
					ErrorCodeEnum.GENERIC_ERROR.getErrorCode(),
					ErrorCodeEnum.GENERIC_ERROR.getErrorMessage());

			log.info("ErrorResponse: {}", errorResponse);
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

		}

}
