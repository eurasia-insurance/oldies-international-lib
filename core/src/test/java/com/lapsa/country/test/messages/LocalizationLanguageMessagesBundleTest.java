package com.lapsa.country.test.messages;

import com.lapsa.localization.LocalizationLanguage;

public class LocalizationLanguageMessagesBundleTest extends EnumTypeMessagesBundleTest<LocalizationLanguage>{

    @Override
    protected LocalizationLanguage[] getAllEnumValues() {
	return LocalizationLanguage.values();
    }

    @Override
    protected String getBundleBaseName() {
	return LocalizationLanguage.BUNDLE_BASENAME;
    }
}
