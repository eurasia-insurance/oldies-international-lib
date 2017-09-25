package test.localization.country;

import com.lapsa.international.country.Country;

import test.localization.ElementsLocalizationTest;

public class CountryRussianTest extends ElementsLocalizationTest<Country> {

    public CountryRussianTest() {
	super(Country.values(), Country.class, LOCALE_RUSSIAN);
    }
}
