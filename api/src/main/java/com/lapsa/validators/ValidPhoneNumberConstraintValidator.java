package com.lapsa.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.phone.PhoneNumber;

public class ValidPhoneNumberConstraintValidator implements ConstraintValidator<ValidPhoneNumber, PhoneNumber> {

    @Override
    public void initialize(ValidPhoneNumber a) {
    }

    @Override
    public boolean isValid(PhoneNumber value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	else
	    return !value.getPlain().isEmpty();
    }

}