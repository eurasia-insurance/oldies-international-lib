package com.lapsa.international.faces.localization;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.lapsa.international.localization.LocalizationLanguage;

import tech.lapsa.java.commons.logging.MyLogger;

@Named("currentLanguageService")
@SessionScoped
public class CurrentLanguageServiceCDIBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalizationLanguage language;

    private static MyLogger logger = MyLogger.newBuilder() //
	    .withNameOf(CurrentLanguageServiceCDIBean.class) //
	    .build();

    @PostConstruct
    public void init() {
	// try to set language defined in user agent
	{
	    final Locale requestedLocale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	    logger.FINER.log("Request locale is '%1$s'", requestedLocale);
	    if (isSupportedLocale(requestedLocale))
		language = byLocale(requestedLocale);
	    logger.FINER.log("Language is : '%1$s'", language);
	}

	// if fails trying to set language defined in application as
	// default
	if (language == null) {
	    final Locale defaultLocale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
	    logger.FINER.log("Application default locale is '%1$s'", defaultLocale);
	    if (isSupportedLocale(defaultLocale))
		language = byLocale(defaultLocale);
	    logger.FINER.log("Language is : '%1$s'", language);
	}

	// if fails then first supported locale used
	if (language == null) {
	    final Locale supportedLocale = firstSupportedLocale();
	    logger.FINER.log("First supported locale is '%1$s'", supportedLocale);
	    language = byLocale(supportedLocale);
	    logger.FINER.log("Language is : '%1$s'", language);
	}

	// if fails seting hardcoded language - RUSSIAN
	if (language == null) {
	    language = LocalizationLanguage.RUSSIAN;
	    logger.FINER.log("Language is : '%1$s'", language);
	}
    }

    private boolean isSupportedLocale(final Locale locale) {
	if (locale == null)
	    return false;
	final Iterator<Locale> supportedLocales = FacesContext.getCurrentInstance().getApplication()
		.getSupportedLocales();
	while (supportedLocales.hasNext()) {
	    final Locale supported = supportedLocales.next();
	    if (supported.getLanguage().equals(locale.getLanguage()))
		return true;
	}
	return false;
    }

    private Locale firstSupportedLocale() {
	final Iterator<Locale> lls = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
	if (lls.hasNext())
	    return lls.next();
	return null;
    }

    public Locale getLocale() {
	return Locale.forLanguageTag(language.getTag());
    }

    public LocalizationLanguage getLanguage() {
	return language;
    }

    public void setLanguage(final LocalizationLanguage language) {
	if (language == null)
	    return;
	final Locale locale = Locale.forLanguageTag(language.getTag());
	if (isSupportedLocale(locale)) {
	    this.language = language;
	    FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
    }

    private static LocalizationLanguage byLocale(final Locale locale) {
	return LocalizationLanguage.byTag(locale.getLanguage());
    }
}
