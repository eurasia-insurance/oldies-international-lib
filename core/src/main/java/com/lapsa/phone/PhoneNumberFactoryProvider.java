package com.lapsa.phone;

import java.util.ServiceLoader;

public abstract class PhoneNumberFactoryProvider {

    public final static PhoneNumberFactory createFactory() {
	ServiceLoader<PhoneNumberFactory> factorySPI = ServiceLoader.load(PhoneNumberFactory.class);
	for (PhoneNumberFactory factory : factorySPI)
	    return factory;
	throw new RuntimeException(
		String.format("There is no any registered %s service provider", PhoneNumberFactory.class.getName()));
    }
}
