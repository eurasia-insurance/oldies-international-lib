package com.lapsa.phone.converter.rs;

import javax.ws.rs.ext.ParamConverter;

import com.lapsa.international.phone.PhoneNumber;

public class PhoneNumberParamConverter implements ParamConverter<PhoneNumber> {

    @Override
    public PhoneNumber fromString(String v) {
	if (v == null || v.isEmpty())
	    throw new IllegalArgumentException();
	return PhoneNumber.parse(v);
    }

    @Override
    public String toString(PhoneNumber v) {
	if (v == null)
	    throw new IllegalArgumentException();
	return v.getFormatted();
    }

}
