package com.lapsa.cars;

public abstract class VINCodeValidatorProvider {

    private final static VINCodeValidator INSTANCE = new DefaultVINCodeValidator();

    public final static VINCodeValidator provideDefault() {
	return INSTANCE;
    }
}
