
package com.lapsa.international.services.bean;

import java.util.Locale;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemService;
import com.lapsa.international.localization.LocalizationLanguage;
import com.lapsa.international.services.LocalizationLanguageService;

@Named("localizationLanguageService")
@ApplicationScoped
public class LocalizationLanguageServiceBean
	implements LocalizationLanguageService, FacesSelectItemService<LocalizationLanguage> {

    @Override
    public LocalizationLanguage[] getSelectable() {
	// TODO HACK подумать как развести CDI и JSF бины
	if (FacesContext.getCurrentInstance() == null)
	    return LocalizationLanguageService.super.getSelectable();

	return Stream.of(LocalizationLanguage.values()) //
		.filter(x -> facesSupportedLocalesStream() //
			.anyMatch(l -> l.getLanguage().equals(x.getTag())))
		.toArray(LocalizationLanguage[]::new);
    }

    @Override
    public LocalizationLanguage[] getNonSelectable() {
	// TODO HACK подумать как развести CDI и JSF бины
	if (FacesContext.getCurrentInstance() == null)
	    return LocalizationLanguageService.super.getNonSelectable();

	return Stream.of(LocalizationLanguage.values()) //
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
