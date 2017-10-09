package test.localization.phone;

import com.lapsa.international.phone.PhoneType;

import test.localization.ElementsLocalizationTest;

public class PhoneTypeKazakhTest extends ElementsLocalizationTest<PhoneType> {

    public PhoneTypeKazakhTest() {
	super(PhoneType.values(), PhoneType.class, LOCALE_KAZAKH);
    }
}
