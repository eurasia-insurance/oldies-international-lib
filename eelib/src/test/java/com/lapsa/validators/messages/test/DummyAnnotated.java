package com.lapsa.validators.messages.test;

import com.lapsa.cars.validators.ValidVINCode;
import com.lapsa.country.validators.ValidCountry;
import com.lapsa.internet.validators.ValidEmail;
import com.lapsa.internet.validators.ValidURL;
import com.lapsa.phone.validators.ValidPhoneNumber;

public interface DummyAnnotated {
    @ValidVINCode
    @ValidCountry
    @ValidEmail
    @ValidURL
    @ValidPhoneNumber
    void dummy();
}
