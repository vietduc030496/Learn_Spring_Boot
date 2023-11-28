package com.vti.demo.request;

import com.vti.demo.annotation.NotEmptyCustom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {
	
	@NotEmptyCustom
	private String username;
	
	@NotEmptyCustom
	private String password;

}
