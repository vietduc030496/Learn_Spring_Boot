package com.vti.demo.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEmptyCustomValidator implements ConstraintValidator<NotEmptyCustom, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && !value.isEmpty();
	}

}
