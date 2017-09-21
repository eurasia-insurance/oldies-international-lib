package com.lapsa.international.services.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemService;
import com.lapsa.international.country.Country;
import com.lapsa.international.services.CountryService;

@Named("countryService")
@ApplicationScoped
public class CountryServiceBean implements CountryService, FacesSelectItemService<Country> {
}
