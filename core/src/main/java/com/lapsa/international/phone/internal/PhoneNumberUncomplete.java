package com.lapsa.international.phone.internal;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lapsa.international.phone.CountryCode;
import com.lapsa.international.phone.PhoneNumber;

import tech.lapsa.java.commons.function.MyObjects;

public final class PhoneNumberUncomplete extends PhoneNumber implements Serializable {
    private static final long serialVersionUID = 8075102729005575472L;

    private final String raw;

    public PhoneNumberUncomplete(String raw) {
	MyObjects.requireNonNull(raw, "Phone number code can not be null");
	this.raw = raw;
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
	return raw;
    }

    @Override
    public String getPlain() {
	return raw;
    }

    @Override
    public CountryCode getCountryCode() {
	return null;
    }

    @Override
    public String getAreaCode() {
	return null;
    }

    @Override
    public String getPhoneNumber() {
	return null;
    }

}
