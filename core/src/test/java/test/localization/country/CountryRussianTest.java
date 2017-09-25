package test.localization;

import com.lapsa.international.country.Country;

public class CountryRussianTest extends ElementsLocalizationTest<Country> {

    public CountryRussianTest() {
	super(Country.values(), Country.class, LOCALE_RUSSIAN);
    }
}
