package test.localization;

import com.lapsa.international.country.Country;

public class CountryKazakh extends ElementsLocalizationTest<Country> {

    public CountryKazakh() {
	super(Country.values(), Country.class, LOCALE_KAZAKH);
    }
}
