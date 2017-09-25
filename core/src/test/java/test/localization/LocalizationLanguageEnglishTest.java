package test.localization;

import com.lapsa.international.localization.LocalizationLanguage;

public class LocalizationLanguageEnglishTest extends ElementsLocalizationTest<LocalizationLanguage> {

    public LocalizationLanguageEnglishTest() {
	super(LocalizationLanguage.values(), LocalizationLanguage.class, LOCALE_ENGLISH);
    }
}
