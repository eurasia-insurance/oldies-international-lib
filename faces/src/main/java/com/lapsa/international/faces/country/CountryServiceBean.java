package com.lapsa.international.faces.country;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemListingService;
import com.lapsa.international.country.Country;

@Named("countryService")
@ApplicationScoped
public class CountryServiceBean implements FacesSelectItemListingService<Country> {

    @Override
    public Country[] getAll() {
	return Country.values();
    }

    @Override
    public Country[] getSelectable() {
	return Country.selectableValues();
    }

    @Override
    public Country[] getNonSelectable() {
	return Country.nonSelectableValues();
    }
}
