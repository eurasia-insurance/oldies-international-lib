package com.lapsa.phone.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.phone.PhoneFormatException;
import com.lapsa.phone.PhoneNumber;
import com.lapsa.phone.PhoneNumberFactoryProvider;

public class ValidPhoneNumberConstraintValidator implements ConstraintValidator<ValidPhoneNumber, Object> {

    private boolean checkPrefix;

    @Override
    public void initialize(ValidPhoneNumber a) {
	this.checkPrefix = a.checkPrefix();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	PhoneNumber testValue = null;
	if (value instanceof String) {
	    try {
		testValue = PhoneNumberFactoryProvider.provideDefault().parse((String) value);
	    } catch (PhoneFormatException e) {
		return false;
	    }
	}
	if (!checkPrefix)
	    return true;
	if (value instanceof PhoneNumber)
	    testValue = (PhoneNumber) value;
	String plain = testValue.getPlain();
	for (String prefix : testValue.getCountryCode().prefixes()) {
	    if (plain.startsWith(prefix))
		return true;
	}
	return false;
    }
}