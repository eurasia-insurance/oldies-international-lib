package com.lapsa.international.phone.converter.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.lapsa.international.phone.PhoneNumber;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;

public class XmlPhoneNumberAdapter extends XmlAdapter<String, PhoneNumber> {

    @Override
    public PhoneNumber unmarshal(String v) throws Exception {
	return MyStrings.empty(v) //
		? null //
		: PhoneNumber.assertValid(v);
    }

    @Override
    public String marshal(PhoneNumber v) throws Exception {
	return MyObjects.isNull(v) //
		? null //
		: v.toString();
    }

}
