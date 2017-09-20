package com.lapsa.country.test.messages;

import com.lapsa.international.phone.PhoneType;

public class PhoneTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<PhoneType> {

    @Override
    protected PhoneType[] getAllEnumValues() {
	return PhoneType.values();
    }
}
