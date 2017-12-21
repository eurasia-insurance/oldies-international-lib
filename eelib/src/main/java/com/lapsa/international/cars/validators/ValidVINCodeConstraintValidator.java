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
    public void initialize(final ValidVINCode constraintAnnotation) {
	validator = VINCodeValidatorProvider.provideDefault();
	checkDigit = constraintAnnotation.checkDigit();
	caseSensitive = constraintAnnotation.caseSensitive();
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	return validator.isValid(value, checkDigit, caseSensitive);
    }
}
