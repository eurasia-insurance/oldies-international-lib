package com.lapsa.phone;

import java.io.Serializable;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.lapsa.phone.jaxb.JAXBPhoneNumberAdapter;

@XmlJavaTypeAdapter(JAXBPhoneNumberAdapter.class)
public class PhoneNumber implements Serializable {

    private static final long serialVersionUID = 8999997304131725827L;

    private CountryCode countryCode;
    private String areaCode;
    private String phoneNumber;

    public static PhoneNumber fromString(String raw) {
	if (raw == null || raw.isEmpty())
	    return null;
	return PhoneNumberParser.parse(raw);
    }

    @Override
    public String toString() {
	return toString(false);
    }

    public String toString(boolean formatted) {
	if (formatted)
	    return getFormatted();
	else
	    return getPlain();
    }

    public PhoneNumber() {
    }

    public PhoneNumber(CountryCode countryCode, String areaCode, String phoneNumber) {
	this.countryCode = countryCode;
	this.areaCode = areaCode;
	this.phoneNumber = phoneNumber;
    }

    public PhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    public String getFormatted() {
	return String.format("+%1$s (%2$s) %3$s", countryCode.getPhoneCode(), areaCode, phoneNumber);
    }

    public String getPlain() {
	return String.format("+%1$s%2$s%3$s", countryCode.getPhoneCode(), areaCode, phoneNumber);
    }

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * (countryCode != null ? countryCode.hashCode() : 555)
		* (areaCode != null ? areaCode.hashCode() : 666) * (phoneNumber != null ? phoneNumber.hashCode() : 777);
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null || !this.getClass().isInstance(obj))
	    return false;
	PhoneNumber pn = (PhoneNumber) obj;
	boolean ret = true;
	ret = ret && countryCode == pn.countryCode;
	ret = ret && safeCompareStrings(areaCode, pn.areaCode);
	ret = ret && safeCompareStrings(phoneNumber, pn.phoneNumber);
	return ret;
    }

    private static boolean safeCompareStrings(String s1, String s2) {
	if ((s1 == null && s2 != null) || (s1 != null && s2 == null))
	    return false;
	if (s1 == null && s2 == null)
	    return true;
	if (s1 != null && s1.equals(s2))
	    return true;
	if (s2 != null && s2.equals(s1))
	    return true;
	return false;
    }

    // GENERATED

    public CountryCode getCountryCode() {
	return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
	this.countryCode = countryCode;
    }

    public String getAreaCode() {
	return areaCode;
    }

    public void setAreaCode(String areaCode) {
	this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
	return phoneNumber;
    }

    public void setPhoneNumber(String number) {
	this.phoneNumber = number;
    }

}
