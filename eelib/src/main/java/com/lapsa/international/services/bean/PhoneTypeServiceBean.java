package com.lapsa.international.services.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemService;
import com.lapsa.international.phone.PhoneType;
import com.lapsa.international.services.PhoneTypeService;

@Named("phoneTypeService")
@ApplicationScoped
public class PhoneTypeServiceBean implements PhoneTypeService, FacesSelectItemService<PhoneType> {
}
