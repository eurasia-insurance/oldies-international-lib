package test.localization;

import com.lapsa.international.country.Country;

public class CountryMessagesBundleTest extends EnumTypeMessagesBundleTest<Country> {

    @Override
    protected Country[] getAllEnumValues() {
	return Country.values();
    }
}
