package com.lapsa.phone;

public abstract class PhoneNumberFactoryProvider {

    private final static PhoneNumberFactory INSTANCE = new DefaultPhoneNumberFactory();

    public final static PhoneNumberFactory provideDefault() {
	return INSTANCE;
    }
}
