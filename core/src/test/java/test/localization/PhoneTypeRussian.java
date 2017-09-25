package test.localization;

import com.lapsa.international.phone.PhoneType;

public class PhoneTypeRussian extends ElementsLocalizationTest<PhoneType> {

    public PhoneTypeRussian() {
	super(PhoneType.values(), PhoneType.class, LOCALE_RUSSIAN);
    }
}
