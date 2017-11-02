package com.lapsa.international.phone;

public class PhoneFormatException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public PhoneFormatException(String message) {
	super(message);
    }

    public PhoneFormatException(String message, Throwable cause) {
	super(message, cause);
    }

}
