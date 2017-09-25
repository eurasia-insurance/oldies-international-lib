package test.localization.localization;

import com.lapsa.international.localization.LocalizationLanguage;

import test.localization.ElementsLocalizationTest;

public class LocalizationLanguageRussianTest extends ElementsLocalizationTest<LocalizationLanguage> {

    public LocalizationLanguageRussianTest() {
	super(LocalizationLanguage.values(), LocalizationLanguage.class, LOCALE_RUSSIAN);
    }
}
