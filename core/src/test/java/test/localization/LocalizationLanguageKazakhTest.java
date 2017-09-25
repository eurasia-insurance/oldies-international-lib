package test.localization;

import com.lapsa.international.localization.LocalizationLanguage;

public class LocalizationLanguageKazakh extends ElementsLocalizationTest<LocalizationLanguage> {

    public LocalizationLanguageKazakh() {
	super(LocalizationLanguage.values(), LocalizationLanguage.class, LOCALE_KAZAKH);
    }
}
