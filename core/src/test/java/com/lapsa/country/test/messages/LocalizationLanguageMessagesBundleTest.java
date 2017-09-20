package com.lapsa.country.test.messages;

import com.lapsa.international.localization.LocalizationLanguage;

public class LocalizationLanguageMessagesBundleTest extends EnumTypeMessagesBundleTest<LocalizationLanguage> {

    @Override
    protected LocalizationLanguage[] getAllEnumValues() {
	return LocalizationLanguage.values();
    }
}
