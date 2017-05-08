package com.lapsa.phone;

import java.util.regex.Pattern;

public final class PhoneNumbers {

    private static final Pattern ONLY_NUMBERS_PATTERN = Pattern.compile("^\\d*$");

    public static String requireOnlyNumbers(String value, String message) throws PhoneFormatException {
	if (!ONLY_NUMBERS_PATTERN.matcher(value).matches())
	    throw new PhoneFormatException(message);
	return value;
    }

    public static String requireOnlyNumbers(String value) throws PhoneFormatException {
	return requireOnlyNumbers(value, String.format("Invalid characters found in phone number '%1$s'", value));
    }

}
