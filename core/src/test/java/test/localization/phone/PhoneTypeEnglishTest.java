package test.localization;

import com.lapsa.international.phone.PhoneType;

public class PhoneTypeEnglishTest extends ElementsLocalizationTest<PhoneType> {

    public PhoneTypeEnglishTest() {
	super(PhoneType.values(), PhoneType.class, LOCALE_ENGLISH);
    }
}
