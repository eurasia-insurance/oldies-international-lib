package com.lapsa.international.localization;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.localization.LocalizedElement;

public enum LocalizationLanguage implements LocalizedElement {
    RUSSIAN("ru"), // русский
    ENGLISH("en", Locale.ENGLISH), // английский
    KAZAKH("kk"), // казахский
    ;

    private final boolean selectable;
    private final String tag;
    private final Locale locale;

    //

    private LocalizationLanguage(final String tag) {
	this.tag = MyObjects.requireNonNull(tag);
	locale = Locale.forLanguageTag(tag);
	selectable = true;
    }

    private LocalizationLanguage(final String tag, final Locale locale) {
	this.tag = MyObjects.requireNonNull(tag);
	this.locale = MyObjects.requireNonNull(locale);
	selectable = true;
    }

    //

    public static final Stream<LocalizationLanguage> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<LocalizationLanguage> SELECTABLE_FILTER = LocalizationLanguage::isSelectable;

    public static final LocalizationLanguage[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(LocalizationLanguage[]::new);
    }

    private static final Predicate<LocalizationLanguage> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final LocalizationLanguage[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(LocalizationLanguage[]::new);
    }

    //

    private static final LocalizationLanguage DEFAULT = LocalizationLanguage.ENGLISH;

    private final static Map<String, LocalizationLanguage> LANGUAGES_BY_TAG = valuesStream() //
	    .collect(Collectors.collectingAndThen(
		    Collectors.toMap(LocalizationLanguage::getTag, Function.identity()),
		    Collections::unmodifiableMap));

    //

    public static LocalizationLanguage byTag(final String tag) {
	return LANGUAGES_BY_TAG.get(tag);
    }

    public static LocalizationLanguage byLocale(final Locale locale) {
	return byTag(locale.getLanguage());
    }

    public static LocalizationLanguage byLocalePriorityListOrDefault(final List<Locale> locales) {
	return locales.stream() //
		.filter(MyObjects::nonNull) //
		.map(LocalizationLanguage::byLocale) //
		.filter(MyObjects::nonNull) //
		.findFirst() //
		.orElse(_orDefault(null));
    }

    public static LocalizationLanguage byTagOrDefault(final String tag) {
	return _orDefault(byTag(tag));
    }

    public static LocalizationLanguage byLocaleOrDefault(final Locale locale) {
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

    public boolean isSelectable() {
	return selectable;
    }

    public String getTag() {
	return tag;
    }

    public Locale getLocale() {
	return locale;
    }
}
