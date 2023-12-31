package com.one.abc.customer.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.one.abc.customer.model.ErrorResponseVO;
import com.one.abc.customer.model.Errors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	@Value("${spring.application.name}")
	private String sourceName;

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Errors> handleOtpServiceException(Exception ex) {

		Errors errors = new Errors();
		List<ErrorResponseVO> errorList = new ArrayList<>();
		getErrorList(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), 1000, errorList);
		errors.setErrors(errorList);
		return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<Errors> handleOtpServiceException(CustomException ex) {

		Errors errors = new Errors();
		List<ErrorResponseVO> errorList = new ArrayList<>();
		getErrorList(ex.getStatusCode(), ex.getMessage(), ex.getStatusCode(), errorList);
		errors.setErrors(errorList);
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	private void getErrorList(int statusCode, String message, int errorCode, List<ErrorResponseVO> errorList) {
		ErrorResponseVO res = new ErrorResponseVO();
		res.setStatus(statusCode);
		res.setMessage(message);
		res.setErrorCode(errorCode);
		res.setSource(sourceName);
		errorList.add(res);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Errors errors = new Errors();
		List<ErrorResponseVO> errorList = new ArrayList<>();
		ex.getAllErrors().forEach(error -> {
			getErrorList(ex.getStatusCode().value(), error.getDefaultMessage(), 1099, errorList);
		});
		errors.setErrors(errorList);
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
