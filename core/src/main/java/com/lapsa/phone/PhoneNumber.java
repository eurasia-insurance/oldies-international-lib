package com.lapsa.phone;

import java.io.Serializable;

public class PhoneNumber implements Serializable {

    private static final long serialVersionUID = 8999997304131725827L;

    private CountryCode countryCode;
    private String areaCode;
    private String number;
    private String raw;

    public PhoneNumber() {
    }

    PhoneNumber(CountryCode countryCode, String areaCode, String number, String raw) {
	this.countryCode = countryCode;
	this.areaCode = areaCode;
	this.number = number;
	this.raw = raw;
    }

    public PhoneNumber(CountryCode countryCode, String areaCode, String number) {
	this.countryCode = countryCode;
	this.areaCode = areaCode;
	this.number = number;
    }

    public String getFormatted() {
	if (countryCode == null || areaCode == null || number == null)
	    return null;
	return String.format("+%1$s (%2$s) %3$s", countryCode.getPhoneCode(), areaCode, number);
    }

    public String getNumbered() {
	if (countryCode == null || areaCode == null || number == null)
	    return null;
	return String.format("%1$s%2$s%3$s", countryCode.getPhoneCode(), areaCode, number);
    }

    @Override
    public String toString() {
	return getFormatted();
    }

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * (countryCode != null ? countryCode.hashCode() : 555)
		* (areaCode != null ? areaCode.hashCode() : 666) * (number != null ? number.hashCode() : 777);
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null || !this.getClass().isInstance(obj))
	    return false;
	PhoneNumber pn = (PhoneNumber) obj;
	boolean ret = true;
	ret = ret && countryCode == pn.getCountryCode();
	ret = ret && safeCompareStrings(areaCode, pn.getAreaCode());
	ret = ret && safeCompareStrings(number, pn.getNumber());
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

    public String getRaw() {
	if (raw != null)
	    return raw;
	return getFormatted();
    }

    protected void setRaw(String raw) {
	this.raw = raw;
    }

    // GENERATED

    public CountryCode getCountryCode() {
	return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
	if (this.countryCode != countryCode)
	    raw = null;
	this.countryCode = countryCode;
    }

    public String getAreaCode() {
	return areaCode;
    }

    public void setAreaCode(String areaCode) {
	if (this.areaCode != areaCode)
	    raw = null;
	this.areaCode = areaCode;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	if (this.number != number)
	    raw = null;
	this.number = number;
    }

}
