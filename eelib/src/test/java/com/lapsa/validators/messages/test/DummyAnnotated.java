package com.lapsa.validators.messages.test;

import com.lapsa.international.cars.validators.ValidVINCode;
import com.lapsa.international.country.validators.ValidCountry;
import com.lapsa.international.phone.validators.ValidPhoneNumber;

public interface DummyAnnotated {
    @ValidVINCode
    @ValidCountry
    @ValidPhoneNumber
    void dummy();
}
