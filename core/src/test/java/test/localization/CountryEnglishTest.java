package test.localization;

import com.lapsa.international.country.Country;

public class CountryEnglish extends ElementsLocalizationTest<Country> {

    public CountryEnglish() {
	super(Country.values(), Country.class, LOCALE_ENGLISH);
    }
}
