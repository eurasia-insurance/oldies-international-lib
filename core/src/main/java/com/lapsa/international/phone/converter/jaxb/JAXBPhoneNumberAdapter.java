package com.lapsa.phone.converter.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.lapsa.phone.PhoneNumber;

public class JAXBPhoneNumberAdapter extends XmlAdapter<String, PhoneNumber> {

    @Override
    public PhoneNumber unmarshal(String v) throws Exception {
	if (v == null || v.isEmpty())
	    return null;
	return PhoneNumber.parse(v);
    }

    @Override
    public String marshal(PhoneNumber v) throws Exception {
	if (v == null)
	    return null;
	return v.toString();
    }

}
