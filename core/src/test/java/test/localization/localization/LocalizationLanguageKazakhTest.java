package test.localization;

import com.lapsa.international.localization.LocalizationLanguage;

public class LocalizationLanguageKazakhTest extends ElementsLocalizationTest<LocalizationLanguage> {

    public LocalizationLanguageKazakhTest() {
	super(LocalizationLanguage.values(), LocalizationLanguage.class, LOCALE_KAZAKH);
    }
}
