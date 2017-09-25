package test.localization;

import com.lapsa.international.country.Country;

public class CountryKazakhTest extends ElementsLocalizationTest<Country> {

    public CountryKazakhTest() {
	super(Country.values(), Country.class, LOCALE_KAZAKH);
    }
}
