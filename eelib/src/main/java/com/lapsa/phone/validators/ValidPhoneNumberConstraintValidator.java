package com.lapsa.phone.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.phone.CountryCode;
import com.lapsa.phone.PhoneNumber;

public class ValidPhoneNumberConstraintValidator implements ConstraintValidator<ValidPhoneNumber, Object> {

    private static final Pattern PATTERN_ONLY_NUMBERS = Pattern.compile("^[0-9]*$");

    @Override
    public void initialize(ValidPhoneNumber a) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	PhoneNumber pn = null;
	if (value instanceof PhoneNumber)
	    pn = (PhoneNumber) value;
	else
	    pn = PhoneNumber.fromString(value.toString());

	{
	    if (pn.getCountryCode() == null)
		return false;
	    if (pn.getAreaCode() == null)
		return false;
	    if (pn.getPhoneNumber() == null)
		return false;
	}

	CountryCode cc = pn.getCountryCode();
	String areaNumber = pn.getAreaCode();
	String fullNumber = pn.getAreaCode() + pn.getPhoneNumber();

	if (!PATTERN_ONLY_NUMBERS.matcher(fullNumber).matches())
	    return false;

	{
	    if (cc.getMinAreaCodeLength() >= 0 && areaNumber.length() < cc.getMinAreaCodeLength())
		return false;
	    if (cc.getMaxAreaCodeLength() >= 0 && areaNumber.length() > cc.getMaxAreaCodeLength())
		return false;
	}

	{
	    if (cc.getMinNumberLength() >= 0 && fullNumber.length() < pn.getCountryCode().getMinAreaCodeLength())
		return false;
	    if (cc.getMaxNumberLength() >= 0 && fullNumber.length() > cc.getMaxNumberLength())
		return false;
	}

	return true;
    }
}