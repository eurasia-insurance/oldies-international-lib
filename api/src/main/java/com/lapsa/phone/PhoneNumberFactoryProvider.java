package com.lapsa.phone;

import com.lapsa.phone.impl.DefaultPhoneNumberFactory;

public abstract class PhoneNumberFactoryProvider {

    public final static PhoneNumberFactory createFactory() {
	return new DefaultPhoneNumberFactory();
    }

}
