package com.lapsa.localization;

import com.lapsa.country.BundleBase;

public enum LocalizationLanguage implements BundleBase {
    RUSSIAN("ru"), // русский
    ENGLISH("en"), // английский
    KAZAKH("kk"), // казахский
    ;

    private final String tag;

    private LocalizationLanguage(String tag) {
	this.tag = tag;
    }

    public String getTag() {
	return tag;
    }

    public static LocalizationLanguage byTag(String lang) {
	for (LocalizationLanguage c : LocalizationLanguage.values())
	    if (c.getTag().equals(lang))
		return c;
	return null;
    }
}
