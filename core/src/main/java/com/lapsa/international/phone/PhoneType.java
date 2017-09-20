package com.lapsa.international.phone;

import com.lapsa.international.country.LocalizedElement;

public enum PhoneType implements LocalizedElement {
    MAIN("fa-phone"), // основной телефон
    FAX("fa-fax"), // телефон факса
    MOBILE("fa-mobile"), // мобильный телефон
    WORK("fa-phone"), // рабочий телефон
    HOME("fa-phone"), // домашний телефон
    //
    ;

    private final String fontAwesomeCodeIcon;

    PhoneType(String fontAwesomeCode) {
	this.fontAwesomeCodeIcon = fontAwesomeCode;
    }

    public String getFontAwesomeIcon() {
	return fontAwesomeCodeIcon;
    }
}
