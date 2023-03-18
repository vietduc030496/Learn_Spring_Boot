package com.vti.demo.response;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExceptionResponse {

	private int statusCode;
	
	private String message;
	
	private Date timestamp;
	
	private String path;
}
