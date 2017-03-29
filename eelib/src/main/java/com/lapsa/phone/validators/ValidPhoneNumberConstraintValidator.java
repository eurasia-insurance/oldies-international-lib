package com.lapsa.phone.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.phone.PhoneNumber;
import com.lapsa.phone.PhoneNumberFactoryProvider;

public class ValidPhoneNumberConstraintValidator implements ConstraintValidator<ValidPhoneNumber, Object> {

    private static final Pattern PATTERN_ONLY_NUMBERS = Pattern.compile("^[0-9]*$");

    private int areaCodeMinLength;
    private int areaCodeMaxLength;

    private int numberMinLength;
    private int numberMaxLength;

    private int fullNumberMinLength;

    private int fullNumberNaxLength;

    @Override
    public void initialize(ValidPhoneNumber a) {
	this.areaCodeMinLength = a.areaCodeMinLength();
	this.areaCodeMaxLength = a.areaCodeMaxLength();
	this.numberMinLength = a.numberMinLength();
	this.numberMaxLength = a.numberMaxLength();
	this.fullNumberMinLength = a.getFullNumberMinLength();
	this.fullNumberNaxLength = a.getFullNumberNaxLength();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	PhoneNumber testValue = null;
	if (value instanceof PhoneNumber)
	    testValue = (PhoneNumber) value;
	else
	    testValue = PhoneNumberFactoryProvider.provideDefault().parse(value.toString());

	{
	    if (testValue.getCountryCode() == null)
		return false;
	}

	{
	    String joined = testValue.getAreaCode() + testValue.getNumber();
	    if (fullNumberMinLength >= 0 && joined.length() < fullNumberMinLength)
		return false;
	    if (fullNumberNaxLength >= 0 && joined.length() > fullNumberNaxLength)
		return false;
	}

	{
	    if (testValue.getAreaCode() == null)
		return false;
	    if (areaCodeMinLength >= 0 && testValue.getAreaCode().length() < areaCodeMinLength)
		return false;
	    if (areaCodeMaxLength >= 0 && testValue.getAreaCode().length() > areaCodeMaxLength)
		return false;
	    if (!PATTERN_ONLY_NUMBERS.matcher(testValue.getAreaCode()).matches())
		return false;
	}

	{
	    if (testValue.getNumber() == null)
		return false;
	    if (numberMinLength >= 0 && testValue.getNumber().length() < numberMinLength)
		return false;
	    if (numberMaxLength >= 0 && testValue.getNumber().length() > numberMaxLength)
		return false;
	    if (!PATTERN_ONLY_NUMBERS.matcher(testValue.getNumber()).matches())
		return false;
	}

	return true;
    }
}