package com.lapsa.international.services.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemService;
import com.lapsa.international.country.Country;

@Named("countryService")
@ApplicationScoped
public class CountryServiceBean implements FacesSelectItemService<Country> {

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
