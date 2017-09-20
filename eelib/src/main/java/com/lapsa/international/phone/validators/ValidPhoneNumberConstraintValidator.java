package com.lapsa.international.phone.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.international.phone.CountryCode;
import com.lapsa.international.phone.PhoneNumber;

public class ValidPhoneNumberConstraintValidator implements ConstraintValidator<ValidPhoneNumber, PhoneNumber> {

    private static final Pattern PATTERN_ONLY_NUMBERS = Pattern.compile("^[0-9]*$");
    private CountryCode[] countriesRequired;

    @Override
    public void initialize(ValidPhoneNumber a) {
	countriesRequired = a.countriesRequired();
    }

    @Override
    public boolean isValid(PhoneNumber value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;

	{
	    if (value.getCountryCode() == null)
		return false;
	    if (value.getAreaCode() == null)
		return false;
	    if (value.getPhoneNumber() == null)
		return false;
	}

	if (countriesRequired != null && countriesRequired.length > 0) {
	    boolean found = false;
	    for (CountryCode cc : countriesRequired)
		if (cc.equals(value.getCountryCode())) {
		    found = true;
		    break;
		}
	    if (!found)
		return false;
	}

	if (!PATTERN_ONLY_NUMBERS.matcher(value.getAreaCode()).matches())
	    return false;
	if (!PATTERN_ONLY_NUMBERS.matcher(value.getPhoneNumber()).matches())
	    return false;

	CountryCode cc = value.getCountryCode();

	{
	    String number = value.getAreaCode();
	    int min = cc.getMinAreaCodeLength();
	    int max = cc.getMaxAreaCodeLength();

	    if (min >= 0 && number.length() < min)
		return false;
	    if (max >= 0 && number.length() > max)
		return false;
	}

	{
	    String number = String.join("", value.getAreaCode(), value.getPhoneNumber());
	    int min = cc.getMinNumberLength();
	    int max = cc.getMaxNumberLength();

	    if (min >= 0 && number.length() < min)
		return false;
	    if (max >= 0 && number.length() > max)
		return false;
	}

	return true;
    }
}