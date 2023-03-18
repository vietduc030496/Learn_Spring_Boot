package com.vti.demo.exception.handle;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vti.demo.exception.StudentNotFoundException;
import com.vti.demo.response.ExceptionResponse;

@RestControllerAdvice
public class ExceptionRestHandle {
	
	@ExceptionHandler(value = {StudentNotFoundException.class, IllegalArgumentException.class})
	public ResponseEntity<?> studentNotFoundExceptionHandle(HttpServletRequest req, HttpServletResponse resp, StudentNotFoundException exception) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(exception.getMessage());
		exceptionResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		exceptionResponse.setTimestamp(new Date());
		exceptionResponse.setPath(req.getRequestURI());
		return ResponseEntity.badRequest().body(exceptionResponse);
	}
}
