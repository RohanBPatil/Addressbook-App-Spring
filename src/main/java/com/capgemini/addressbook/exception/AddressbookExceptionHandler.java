package com.capgemini.addressbook.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capgemini.addressbook.dto.ResponseDTO;

@ControllerAdvice
public class AddressbookExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errList = exception.getBindingResult().getAllErrors();
		List<String> errMessages = errList.stream().map(error -> error.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Exception occured method argument not valid ", errMessages);
		
		return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AddressbookException.class)
	public ResponseEntity<ResponseDTO> handleEmployeeException(AddressbookException empException) {
		ResponseDTO responseDTO = new ResponseDTO("Exception occured", empException.getMessage());
		return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}
