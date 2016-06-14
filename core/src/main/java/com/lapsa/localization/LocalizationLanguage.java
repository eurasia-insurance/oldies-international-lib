package com.lapsa.localization;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.lapsa.country.InternationalLocalizationBundleBase;

public enum LocalizationLanguage implements InternationalLocalizationBundleBase {
    RUSSIAN("ru"), // русский
    ENGLISH("en"), // английский
    KAZAKH("kk"), // казахский
    //
    ;

    private final static Map<String, LocalizationLanguage> langTags;

    static {
	langTags = new HashMap<>();
	for (LocalizationLanguage ll : LocalizationLanguage.values())
	    langTags.put(ll.getTag(), ll);
    }

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
	return langTags.get(lang);
    }

    public static LocalizationLanguage byLocale(Locale locale) {
	return langTags.get(locale.getLanguage());
    }
}
