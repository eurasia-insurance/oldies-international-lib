package com.lapsa.phone.internal;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lapsa.phone.CountryCode;
import com.lapsa.phone.PhoneNumber;

public final class PhoneNumberComplete extends PhoneNumber implements Serializable {
    private static final long serialVersionUID = 8999997304131725827L;

    private static final String DEFAULT_FORMATTED_FORMAT = "+%1$s %2$s %3$s";
    private static final String DEFAULT_PLAIN_FORMAT = "%1$s%2$s%3$s";

    private final CountryCode countryCode;
    private final String areaCode;
    private final String phoneNumber;

    public PhoneNumberComplete(CountryCode countryCode, String areaCode, String phoneNumber) {
	Objects.requireNonNull(countryCode, "Country code can not be null");
	Objects.requireNonNull(countryCode, "Area code can not be null");
	Objects.requireNonNull(phoneNumber, "Phone number can not be null");
	this.countryCode = countryCode;
	this.areaCode = areaCode;
	this.phoneNumber = phoneNumber;
    }

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
	String format = countryCode != null && countryCode.getFormat() != null ? countryCode.getFormat()
		: DEFAULT_FORMATTED_FORMAT;
	return String.format(format, countryCode.getPhoneCode(), areaCode, phoneNumber);
    }

    @Override
    public String getPlain() {
	return String.format(DEFAULT_PLAIN_FORMAT, //
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
