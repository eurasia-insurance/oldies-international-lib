package test.localization;

import com.lapsa.international.country.Country;

public class CountryEnglishTest extends ElementsLocalizationTest<Country> {

    public CountryEnglishTest() {
	super(Country.values(), Country.class, LOCALE_ENGLISH);
    }
}
