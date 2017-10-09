package test.localization.country;

import com.lapsa.international.country.Country;

import test.localization.ElementsLocalizationTest;

public class CountryKazakhTest extends ElementsLocalizationTest<Country> {

    public CountryKazakhTest() {
	super(Country.values(), Country.class, LOCALE_KAZAKH);
    }
}
