package com.lapsa.international;

import com.lapsa.commons.elements.LocalizedElement;

public interface InternationalLocalizedElement extends LocalizedElement {

    public static final String BUNDLE_BASENAME = "InternationalLocalization";

    @Override
    default String getBundleBaseName() {
	return BUNDLE_BASENAME;
    }
}
