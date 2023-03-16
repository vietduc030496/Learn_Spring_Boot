package com.vti.demo.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.utils.I18nUtils;

import lombok.NonNull;

@RestController
@RequestMapping("/api")
public class MessageController {

	@GetMapping("/message/{code}")
	public String getMessage(@PathVariable("code") @NonNull String code, HttpServletRequest request) {
		Locale locale = request.getLocale();
		return I18nUtils.getMessage(code, locale);
	}
}
