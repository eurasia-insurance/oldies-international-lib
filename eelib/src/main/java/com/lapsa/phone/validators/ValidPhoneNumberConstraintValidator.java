package com.lapsa.phone.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.phone.CountryCode;
import com.lapsa.phone.PhoneNumber;

public class ValidPhoneNumberConstraintValidator implements ConstraintValidator<ValidPhoneNumber, Object> {

    private static final Pattern PATTERN_ONLY_NUMBERS = Pattern.compile("^[0-9]*$");

    private int areaCodeLength;
    private int numberLength;

    @Override
    public void initialize(ValidPhoneNumber a) {
	this.areaCodeLength = a.areaCodeLength();
	this.numberLength = a.numberLength();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	PhoneNumber testValue = null;
	if (value instanceof PhoneNumber)
	    testValue = (PhoneNumber) value;
	else
	    testValue = new PhoneNumber(value.toString());

	if (!isValidCountryCode(testValue.getCountryCode()))
	    return false;

	if (!isValidAreaCode(testValue.getAreaCode()))
	    return false;

	if (!isValidNumber(testValue.getNumber()))
	    return false;

	return true;
    }

    protected boolean isValidCountryCode(CountryCode countryCode) {
	return countryCode != null;
    }

    private boolean isValidNumber(String number) {
	if (number == null)
	    return false;
	if (number.length() != numberLength)
	    return false;
	if (!PATTERN_ONLY_NUMBERS.matcher(number).matches())
	    return false;
	return true;
    }

    private boolean isValidAreaCode(String areaCode) {
	if (areaCode == null)
	    return false;
	if (areaCode.length() != areaCodeLength)
	    return false;
	if (!PATTERN_ONLY_NUMBERS.matcher(areaCode).matches())
	    return false;
	return true;
    }
}