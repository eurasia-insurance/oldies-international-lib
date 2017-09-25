package test.localization;

import com.lapsa.international.phone.PhoneType;

public class PhoneTypeRussianTest extends ElementsLocalizationTest<PhoneType> {

    public PhoneTypeRussianTest() {
	super(PhoneType.values(), PhoneType.class, LOCALE_RUSSIAN);
    }
}
