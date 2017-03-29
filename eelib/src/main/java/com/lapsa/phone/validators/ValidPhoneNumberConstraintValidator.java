package com.lapsa.phone.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.phone.PhoneFormatException;
import com.lapsa.phone.PhoneNumber;
import com.lapsa.phone.PhoneNumberFactoryProvider;

public class ValidPhoneNumberConstraintValidator implements ConstraintValidator<ValidPhoneNumber, Object> {

    private boolean checkPrefix;
    private int areaCodeLength;
    private int numberLength;

    @Override
    public void initialize(ValidPhoneNumber a) {
	this.checkPrefix = a.checkPrefix();
	this.areaCodeLength = a.areaCodeLength();
	this.numberLength = a.numberLength();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	PhoneNumber testValue = null;
	if (value instanceof PhoneNumber) {
	    testValue = (PhoneNumber) value;
	} else {
	    String stringValue = null;
	    if (value instanceof String)
		stringValue = (String) value;
	    else
		stringValue = value.toString();
	    try {
		testValue = PhoneNumberFactoryProvider.provideDefault().parse(stringValue);
	    } catch (PhoneFormatException e) {
		return false;
	    }
	}

	if (checkPrefix && !checkPrefix(testValue))
	    return false;
	if (areaCodeLength > 0 && !checkAreaCode(testValue))
	    return false;
	if (numberLength > 0 && !checkNumberLength(testValue))
	    return false;

	return true;
    }

    private boolean checkNumberLength(PhoneNumber testValue) {
	return testValue.getNumber() != null && testValue.getNumber().length() == numberLength;
    }

    private boolean checkAreaCode(PhoneNumber testValue) {
	return testValue.getAreaCode() != null && testValue.getAreaCode().length() == areaCodeLength;
    }

    private boolean checkPrefix(PhoneNumber testValue) {
	String plain = testValue.getPlain();
	for (String prefix : testValue.getCountryCode().prefixes()) {
	    if (plain.startsWith(prefix))
		return true;
	}
	return false;
    }
}