package com.lapsa.international.phone.converter.rs;

import java.util.Map.Entry;

import javax.ws.rs.ext.ParamConverter;

import com.lapsa.international.phone.PhoneNumber;

import tech.lapsa.java.commons.function.MyMaps;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.javax.rs.params.MyParamConverterProvider;

public class PhoneNumberParamConverter implements ParamConverter<PhoneNumber>, MyParamConverterProvider<PhoneNumber> {

    @Override
    public PhoneNumber fromString(String v) {
	return PhoneNumber.assertValid(v);
    }

    @Override
    public String toString(PhoneNumber value) {
	return MyObjects.requireNonNull(value, "value").getFormatted();
    }

    private static Entry<Class<PhoneNumber>, ParamConverter<PhoneNumber>> ENTRY = MyMaps
	    .entry(PhoneNumber.class, new PhoneNumberParamConverter());

    @Override
    public Entry<Class<PhoneNumber>, ParamConverter<PhoneNumber>> entry() {
	return ENTRY;
    }
}
