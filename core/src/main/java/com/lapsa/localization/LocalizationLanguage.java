package com.lapsa.localization;

import java.util.Locale;

import com.lapsa.country.InternationalLocalizationBundleBase;

public enum LocalizationLanguage implements InternationalLocalizationBundleBase {
    RUSSIAN("ru"), // русский
    ENGLISH("en"), // английский
    KAZAKH("kk"), // казахский
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }

    private final String tag;
    private final Locale locale;

    private LocalizationLanguage(String tag) {
	this.tag = tag;
	this.locale = Locale.forLanguageTag(tag);
    }

    public String getTag() {
	return tag;
    }

    public Locale getLocale() {
	return locale;
    }

    public static LocalizationLanguage byTag(String lang) {
	for (LocalizationLanguage c : LocalizationLanguage.values())
	    if (c.getTag().equals(lang))
		return c;
	return null;
    }
}
