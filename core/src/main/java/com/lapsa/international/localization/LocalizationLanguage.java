package com.lapsa.international.localization;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.lapsa.international.country.LocalizedElement;

public enum LocalizationLanguage implements LocalizedElement {
    RUSSIAN("ru"), // русский
    ENGLISH("en", Locale.ENGLISH), // английский
    KAZAKH("kk"), // казахский
    //
    ;

    private static final LocalizationLanguage DEFAULT = LocalizationLanguage.ENGLISH;
    private final static Map<String, LocalizationLanguage> LANGUAGES_BY_TAG;

    static {
	Map<String, LocalizationLanguage> map = new HashMap<>();
	for (LocalizationLanguage ll : LocalizationLanguage.values())
	    map.put(ll.getTag(), ll);
	LANGUAGES_BY_TAG = Collections.unmodifiableMap(map);
    }

    private final String tag;
    private final Locale locale;

    private LocalizationLanguage(String tag) {
	this.tag = tag;
	this.locale = Locale.forLanguageTag(tag);
    }

    private LocalizationLanguage(String tag, Locale locale) {
	this.tag = tag;
	this.locale = locale;
    }

    public String getTag() {
	return tag;
    }

    public Locale getLocale() {
	return locale;
    }

    public static LocalizationLanguage byTag(String tag) {
	return LANGUAGES_BY_TAG.get(tag);
    }

    public static LocalizationLanguage byLocale(Locale locale) {
	return byTag(locale.getLanguage());
    }

    public static LocalizationLanguage byLocalePriorityListOrDefault(List<Locale> locales) {
	try {
	    for (Locale locale : locales) {
		LocalizationLanguage lang = byLocale(locale);
		if (lang != null)
		    return lang;
	    }
	} catch (NullPointerException ignored) {
	}
	return _orDefault(null);
    }

    public static LocalizationLanguage byTagOrDefault(String tag) {
	return _orDefault(byTag(tag));
    }

    public static LocalizationLanguage byLocaleOrDefault(Locale locale) {
	return _orDefault(byLocale(locale));
    }

    public static LocalizationLanguage getDefault() {
	return _orDefault(null);
    }

    // PRIVATE STATIC

    private static LocalizationLanguage _orDefault(final LocalizationLanguage lang) {
	LocalizationLanguage result = lang;
	if (result == null)
	    result = byLocale(Locale.getDefault());
	if (result == null)
	    result = DEFAULT;
	return result;
    }
}
