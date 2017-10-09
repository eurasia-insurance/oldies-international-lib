package test.localization.phone;

import com.lapsa.international.phone.PhoneType;

import test.localization.ElementsLocalizationTest;

public class PhoneTypeEnglishTest extends ElementsLocalizationTest<PhoneType> {

    public PhoneTypeEnglishTest() {
	super(PhoneType.values(), PhoneType.class, LOCALE_ENGLISH);
    }
}
