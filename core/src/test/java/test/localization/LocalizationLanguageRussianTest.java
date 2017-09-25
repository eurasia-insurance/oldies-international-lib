package test.localization;

import com.lapsa.international.localization.LocalizationLanguage;

public class LocalizationLanguageRussian extends ElementsLocalizationTest<LocalizationLanguage> {

    public LocalizationLanguageRussian() {
	super(LocalizationLanguage.values(), LocalizationLanguage.class, LOCALE_RUSSIAN);
    }
}
