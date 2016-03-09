package com.lapsa.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.phone.PhoneNumber;

public class ValidPhoneNumberConstraintValidator implements ConstraintValidator<ValidPhoneNumber, PhoneNumber> {

    private boolean checkPrefix;

    @Override
    public void initialize(ValidPhoneNumber a) {
	this.checkPrefix = a.checkPrefix();
    }

    @Override
    public boolean isValid(PhoneNumber value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	if (!checkPrefix) {
	    return true;
	}
	String plain = value.getPlain();
	for (String prefix : value.getCountryCode().prefixes()) {
	    if (plain.startsWith(prefix))
		return true;
	}
	return false;
    }

}