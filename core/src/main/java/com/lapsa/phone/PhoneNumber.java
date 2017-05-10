package com.lapsa.phone;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.lapsa.phone.jaxb.JAXBPhoneNumberAdapter;

@XmlJavaTypeAdapter(JAXBPhoneNumberAdapter.class)
public interface PhoneNumber {

    String getFormatted();

    String getPlain();

    boolean isComplete();

    CountryCode getCountryCode();

    String getAreaCode();

    String getPhoneNumber();
}
