package com.practice.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {ConstraintViolationException.class})
	public final ResponseEntity<Object> handleBadRequest(final RuntimeException ex, final WebRequest request) {
		return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	private ApiError message(HttpStatus status, Exception ex) {
		String message = ex.getMessage() == null ?ex.getClass().getSimpleName() : ex.getMessage();
		return new ApiError(status.value(), message);
	}

}
