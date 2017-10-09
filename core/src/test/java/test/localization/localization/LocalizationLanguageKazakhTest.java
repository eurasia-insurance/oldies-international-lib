package test.localization.localization;

import com.lapsa.international.localization.LocalizationLanguage;

import test.localization.ElementsLocalizationTest;

public class LocalizationLanguageKazakhTest extends ElementsLocalizationTest<LocalizationLanguage> {

    public LocalizationLanguageKazakhTest() {
	super(LocalizationLanguage.values(), LocalizationLanguage.class, LOCALE_KAZAKH);
    }
}
