package com.lapsa.country.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.country.Country;
import com.lapsa.validators.AllowDenyOrder;

public class ValidCountryConstraintValidator implements ConstraintValidator<ValidCountry, Country> {

    private Country[] allowValues;
    private Country[] denyValues;
    private AllowDenyOrder mode;

    @Override
    public void initialize(ValidCountry a) {
	this.allowValues = a.alloweValues();
	this.denyValues = a.denyValues();
	this.mode = a.mode();
    }

    @Override
    public boolean isValid(Country value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	switch (mode) {
	case DENY_ALL_NOT_ALLOWED:
	    for (Country s : allowValues)
		if (s == value)
		    return true;
	    return false; // запрещено все, что не разрешено
	case ALLOW_ALL_NOT_DENIED:
	    for (Country s : denyValues)
		if (s == value)
		    return false;
	    return true; // разрешено все, что не запрещено
	default:
	    return false;
	}
    }
}