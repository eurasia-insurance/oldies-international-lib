package com.lapsa.international.country.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.international.country.Country;
import com.lapsa.international.validators.AllowDenyOrder;

public class ValidCountryConstraintValidator implements ConstraintValidator<ValidCountry, Country> {

    private Country[] allowValues;
    private Country[] denyValues;
    private AllowDenyOrder mode;

    @Override
    public void initialize(final ValidCountry a) {
	allowValues = a.alloweValues();
	denyValues = a.denyValues();
	mode = a.mode();
    }

    @Override
    public boolean isValid(final Country value, final ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	switch (mode) {
	case DENY_ALL_NOT_ALLOWED:
	    for (final Country s : allowValues)
		if (s == value)
		    return true;
	    return false; // запрещено все, что не разрешено
	case ALLOW_ALL_NOT_DENIED:
	    for (final Country s : denyValues)
		if (s == value)
		    return false;
	    return true; // разрешено все, что не запрещено
	default:
	    return false;
	}
    }
}