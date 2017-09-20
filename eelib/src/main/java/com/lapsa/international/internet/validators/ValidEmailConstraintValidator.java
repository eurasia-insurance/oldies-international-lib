package com.lapsa.internet.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEmailConstraintValidator implements ConstraintValidator<ValidEmail, String> {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private Pattern pattern;

    @Override
    public void initialize(ValidEmail a) {
	pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	return pattern.matcher(value.toString()).matches();
    }

}