
package com.lapsa.international.faces.localization;

import java.util.Locale;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.lapsa.international.localization.LocalizationLanguage;

import tech.lapsa.javax.faces.commons.beans.localization.ListingBean;

@Named("LocalizationLanguage")
@ApplicationScoped
public class LocalizationLanguageCDIBean implements ListingBean<LocalizationLanguage> {

    @Override
    public LocalizationLanguage[] getAll() {
	return LocalizationLanguage.values();
    }

    @Override
    public LocalizationLanguage[] getSelectable() {
	if (FacesContext.getCurrentInstance() == null)
	    // is not on Faces context so use default implementation
	    return LocalizationLanguage.selectableValues();

	return LocalizationLanguage.valuesStream() //
		.filter(x -> facesSupportedLocalesStream() //
			.anyMatch(l -> l.getLanguage().equals(x.getTag())))
		.toArray(LocalizationLanguage[]::new);
    }

    @Override
    public LocalizationLanguage[] getNonSelectable() {
	if (FacesContext.getCurrentInstance() == null)
	    // is not on Faces context so use default implementation
	    return LocalizationLanguage.nonSelectableValues();

	return LocalizationLanguage.valuesStream() //
		.filter(x -> facesSupportedLocalesStream() //
			.noneMatch(l -> l.getLanguage().equals(x.getTag())))
		.toArray(LocalizationLanguage[]::new);
    }

    //

    private static Stream<Locale> facesSupportedLocalesStream() {
	Iterable<Locale> it = FacesContext.getCurrentInstance()
		.getApplication()::getSupportedLocales;
	return StreamSupport.stream(it.spliterator(), false);
    }
}
