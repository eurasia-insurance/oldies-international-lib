package test.localization;

import com.lapsa.international.phone.PhoneType;

public class PhoneTypeKazakh extends ElementsLocalizationTest<PhoneType> {

    public PhoneTypeKazakh() {
	super(PhoneType.values(), PhoneType.class, LOCALE_KAZAKH);
    }
}
