package com.lapsa.international.services;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.international.country.Country;

public interface CountryService extends NamingListingService<Country> {

    @Override
    default Country[] getAll() {
	return Country.values();
    }

    @Override
    default Country[] getSelectable() {
	return Country.selectableValues();
    }

    @Override
    default Country[] getNonSelectable() {
	return Country.nonSelectableValues();
    }
}
