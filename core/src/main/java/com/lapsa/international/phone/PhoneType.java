package com.lapsa.international.phone;

import java.util.function.Predicate;
import java.util.stream.Stream;

import com.lapsa.commons.elements.LocalizedElement;

public enum PhoneType implements LocalizedElement {
    MAIN("fa-phone"), // основной телефон
    FAX("fa-fax"), // телефон факса
    MOBILE("fa-mobile"), // мобильный телефон
    WORK("fa-phone"), // рабочий телефон
    HOME("fa-phone"), // домашний телефон
    ;

    //

    private final boolean selectable;
    private final String fontAwesomeCodeIcon;

    //

    private PhoneType(String fontAwesomeCode) {
	this.fontAwesomeCodeIcon = fontAwesomeCode;
	this.selectable = true;
    }

    private PhoneType(String fontAwesomeCode, boolean selectable) {
	this.fontAwesomeCodeIcon = fontAwesomeCode;
	this.selectable = selectable;
    }

    //

    public static final Stream<PhoneType> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<PhoneType> SELECTABLE_FILTER = PhoneType::isSelectable;

    public static final PhoneType[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(PhoneType[]::new);
    }

    private static final Predicate<PhoneType> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final PhoneType[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(PhoneType[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }

    public String getFontAwesomeIcon() {
	return fontAwesomeCodeIcon;
    }
}
