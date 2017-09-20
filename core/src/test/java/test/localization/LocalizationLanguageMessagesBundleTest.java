package test.localization;

import com.lapsa.international.localization.LocalizationLanguage;

public class LocalizationLanguageMessagesBundleTest extends EnumTypeMessagesBundleTest<LocalizationLanguage> {

    @Override
    protected LocalizationLanguage[] getAllEnumValues() {
	return LocalizationLanguage.values();
    }
}
