package com.lapsa.international.cars.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.international.cars.VINCodeValidator;
import com.lapsa.international.cars.VINCodeValidatorProvider;

public class ValidVINCodeConstraintValidator implements ConstraintValidator<ValidVINCode, String> {

    private boolean checkDigit;
    private boolean caseSensitive;

    private VINCodeValidator validator;

    @Override
    public void initialize(ValidVINCode constraintAnnotation) {
	validator = VINCodeValidatorProvider.provideDefault();
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
