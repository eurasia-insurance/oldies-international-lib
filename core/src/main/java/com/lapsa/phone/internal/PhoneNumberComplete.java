package com.lapsa.phone;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

final class PhoneNumberComplete implements Serializable, PhoneNumber {

    private static final long serialVersionUID = 8999997304131725827L;

    private final CountryCode countryCode;
    private final String areaCode;
    private final String phoneNumber;

    PhoneNumberComplete(CountryCode countryCode, String areaCode, String phoneNumber) {
	Objects.requireNonNull(countryCode, "Country code can not be null");
	Objects.requireNonNull(countryCode, "Area code can not be null");
	Objects.requireNonNull(phoneNumber, "Phone number can not be null");
	this.countryCode = countryCode;
	this.areaCode = areaCode;
	this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isComplete() {
	return countryCode != null && areaCode != null && phoneNumber != null;
    }

    @Override
    public int hashCode() {
	return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
	return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }

    @Override
    public String getFormatted() {
	if (!isComplete())
	    return getPlain();
	return String.format("+%1$s (%2$s) %3$s", countryCode.getPhoneCode(), areaCode, phoneNumber);
    }

    @Override
    public String getPlain() {
	return String.format("%1$s%2$s%3$s", //
		countryCode == null ? "" : countryCode.getPhoneCode(), // 1
		areaCode == null ? "" : areaCode, // 2
		phoneNumber == null ? "" : phoneNumber // 3
	);
    }

    // GENERATED

    @Override
    public CountryCode getCountryCode() {
	return countryCode;
    }

    @Override
    public String getAreaCode() {
	return areaCode;
    }

    @Override
    public String getPhoneNumber() {
	return phoneNumber;
    }
}
