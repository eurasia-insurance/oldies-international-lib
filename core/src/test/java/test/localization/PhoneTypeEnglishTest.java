package test.localization;

import com.lapsa.international.phone.PhoneType;

public class PhoneTypeEnglish extends ElementsLocalizationTest<PhoneType> {

    public PhoneTypeEnglish() {
	super(PhoneType.values(), PhoneType.class, LOCALE_ENGLISH);
    }
}
