package com.lapsa.country;

public interface LocalizedElement {
    public static final String BUNDLE_BASENAME = "InternationalLocalization";
    public static final String BUNDLE_VAR = "il";

    String canonicalName();
}
