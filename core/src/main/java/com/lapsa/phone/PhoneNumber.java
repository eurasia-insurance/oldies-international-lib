package com.lapsa.phone;

public class PhoneNumber {

    private CountryCode countryCode;
    private String areaCode;
    private String number;

    public PhoneNumber() {
    }

    public PhoneNumber(CountryCode countryCode, String areaCode, String number) {
	this.countryCode = countryCode;
	this.areaCode = areaCode;
	this.number = number;
    }

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

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public String getFormatted() {
	return String.format("+%1$s (%2$s) %3$s", (countryCode != null ? countryCode.getPhoneCode() : ""),
		(areaCode != null ? areaCode : ""), (number != null ? number : ""));
    }

    public String getPlain() {
	return (countryCode != null ? countryCode.getPhoneCode() : "") + (areaCode != null ? areaCode : "")
		+ (number != null ? number : "");
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
}
