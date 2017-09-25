package test.localization;

import com.lapsa.international.phone.PhoneType;

public class PhoneTypeKazakhTest extends ElementsLocalizationTest<PhoneType> {

    public PhoneTypeKazakhTest() {
	super(PhoneType.values(), PhoneType.class, LOCALE_KAZAKH);
    }
}
