package com.lapsa.localization;

import java.util.Collections;
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

    private final static Map<String, LocalizationLanguage> LANGUAGES_BY_TAG;

    static {
	Map<String, LocalizationLanguage> map = new HashMap<>();
	for (LocalizationLanguage ll : LocalizationLanguage.values())
	    map.put(ll.getTag(), ll);
	LANGUAGES_BY_TAG = Collections.unmodifiableMap(map);
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
	return LANGUAGES_BY_TAG.get(lang);
    }

    public static LocalizationLanguage byLocale(Locale locale) {
	return LANGUAGES_BY_TAG.get(locale.getLanguage());
    }

    public static LocalizationLanguage getDefault() {
	LocalizationLanguage lang = byLocale(Locale.getDefault());
	if (lang == null)
	    lang = LocalizationLanguage.ENGLISH;
	return lang;
    }
}
