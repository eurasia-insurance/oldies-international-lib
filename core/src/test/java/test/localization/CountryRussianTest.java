package test.localization;

import com.lapsa.international.country.Country;

public class CountryRussian extends ElementsLocalizationTest<Country> {

    public CountryRussian() {
	super(Country.values(), Country.class, LOCALE_RUSSIAN);
    }
}
