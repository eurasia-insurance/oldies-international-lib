package test.localization.localization;

import com.lapsa.international.localization.LocalizationLanguage;

import test.localization.ElementsLocalizationTest;

public class LocalizationLanguageEnglishTest extends ElementsLocalizationTest<LocalizationLanguage> {

    public LocalizationLanguageEnglishTest() {
	super(LocalizationLanguage.values(), LocalizationLanguage.class, LOCALE_ENGLISH);
    }
}
