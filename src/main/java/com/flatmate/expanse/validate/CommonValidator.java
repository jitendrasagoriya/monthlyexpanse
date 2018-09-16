package com.flatmate.expanse.validate;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class CommonValidator<T> {
	
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	private Validator validator = factory.getValidator();
	
	public Set<ConstraintViolation<T>> validate(T t){
		return validator.validate(t);
	}

}
