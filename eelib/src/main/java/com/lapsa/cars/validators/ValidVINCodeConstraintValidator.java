package com.lapsa.cars.validators;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.cars.VINCodeValidator;

public class ValidVINCodeConstraintValidator implements ConstraintValidator<ValidVINCode, String> {

    private boolean checkDigit;
    private boolean caseSensitive;

    @Inject
    private VINCodeValidator validator;

    @Override
    public void initialize(ValidVINCode constraintAnnotation) {
	checkDigit = constraintAnnotation.checkDigit();
	caseSensitive = constraintAnnotation.caseSensitive();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	return validator.isValid(value, checkDigit, caseSensitive);
    }
}
