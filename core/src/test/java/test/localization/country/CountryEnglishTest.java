package test.localization.country;

import com.lapsa.international.country.Country;

import test.localization.ElementsLocalizationTest;

public class CountryEnglishTest extends ElementsLocalizationTest<Country> {

    public CountryEnglishTest() {
	super(Country.values(), Country.class, LOCALE_ENGLISH);
    }
}
