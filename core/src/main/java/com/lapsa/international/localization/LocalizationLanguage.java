package com.lapsa.international.localization;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.lapsa.international.InternationalLocalizedElement;

public enum LocalizationLanguage implements InternationalLocalizedElement {
    RUSSIAN("ru"), // русский
    ENGLISH("en", Locale.ENGLISH), // английский
    KAZAKH("kk"), // казахский
    //
    ;

    private final String tag;
    private final Locale locale;

    //

    private LocalizationLanguage(String tag) {
	this.tag = tag;
	this.locale = Locale.forLanguageTag(tag);
    }

    private LocalizationLanguage(String tag, Locale locale) {
	this.tag = tag;
	this.locale = locale;
    }

    //

    private static final LocalizationLanguage DEFAULT = LocalizationLanguage.ENGLISH;

    private final static Map<String, LocalizationLanguage> LANGUAGES_BY_TAG = Stream.of(LocalizationLanguage.values()) //
	    .collect(Collectors.collectingAndThen(
		    Collectors.toMap(LocalizationLanguage::getTag, Function.identity()),
		    Collections::unmodifiableMap));

    //

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

    private static LocalizationLanguage _orDefault(final LocalizationLanguage lang) {
	LocalizationLanguage result = lang;
	if (result == null)
	    result = byLocale(Locale.getDefault());
	if (result == null)
	    result = DEFAULT;
	return result;
    }

    // GENERATED

    public String getTag() {
	return tag;
    }

    public Locale getLocale() {
	return locale;
    }

}
