package com.lapsa.country;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CountryXmlAdapter extends XmlAdapter<String, Country> {

    @Override
    public Country unmarshal(String v) throws Exception {
	if (v == null)
	    return null;
	Country c = Country.forAlpha3Code(v);
	if (c != null)
	    return c;
	return Country.OTHR;
    }

    @Override
    public String marshal(Country v) throws Exception {
	if (v == null)
	    return null;
	return v.getAlpha3Code();
    }

}
