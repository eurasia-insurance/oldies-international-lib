package com.lapsa.international.phone;

public class PhoneFormatException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public PhoneFormatException(final String message) {
	super(message);
    }

    public PhoneFormatException(final String message, final Throwable cause) {
	super(message, cause);
    }

}
