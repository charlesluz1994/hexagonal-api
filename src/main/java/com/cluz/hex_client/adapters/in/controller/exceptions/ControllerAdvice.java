package com.cluz.hex_client.adapters.in.controller.exceptions;

import com.cluz.hex_client.application.core.exceptions.CustomerNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

/**
 * Class used as an interceptor of exceptions into the application.
 */
@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Error> customerNotFoundException(CustomerNotFoundException ex, HttpServletRequest request) {
		var error = new Error(
				ZonedDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				request.getRequestURI()
		);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
