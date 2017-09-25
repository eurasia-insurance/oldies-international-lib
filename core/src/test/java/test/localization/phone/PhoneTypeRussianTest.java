package test.localization.phone;

import com.lapsa.international.phone.PhoneType;

import test.localization.ElementsLocalizationTest;

public class PhoneTypeRussianTest extends ElementsLocalizationTest<PhoneType> {

    public PhoneTypeRussianTest() {
	super(PhoneType.values(), PhoneType.class, LOCALE_RUSSIAN);
    }
}
