package test.localization;

import com.lapsa.international.localization.LocalizationLanguage;

public class LocalizationLanguageEnglish extends ElementsLocalizationTest<LocalizationLanguage> {

    public LocalizationLanguageEnglish() {
	super(LocalizationLanguage.values(), LocalizationLanguage.class, LOCALE_ENGLISH);
    }
}
