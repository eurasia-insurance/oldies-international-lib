package test.localization;

import com.lapsa.international.localization.LocalizationLanguage;

public class LocalizationLanguageRussianTest extends ElementsLocalizationTest<LocalizationLanguage> {

    public LocalizationLanguageRussianTest() {
	super(LocalizationLanguage.values(), LocalizationLanguage.class, LOCALE_RUSSIAN);
    }
}
