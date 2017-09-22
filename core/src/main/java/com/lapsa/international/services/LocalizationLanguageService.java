
package com.lapsa.international.services;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.international.localization.LocalizationLanguage;

public interface LocalizationLanguageService extends NamingListingService<LocalizationLanguage> {

    @Override
    default LocalizationLanguage[] getAll() {
	return LocalizationLanguage.values();
    }

    @Override
    default LocalizationLanguage[] getSelectable() {
	return LocalizationLanguage.selectableValues();
    }

    @Override
    default LocalizationLanguage[] getNonSelectable() {
	return LocalizationLanguage.nonSelectableValues();
    }
}
