package com.lapsa.phone;

public interface PhoneNumberFactory {
    PhoneNumber create(CountryCode country, String number) throws PhoneFormatException;

    PhoneNumber parse(String anyFormat) throws PhoneFormatException;

    PhoneNumber parse(String anyFormat, CountryCode defaultCountryCode) throws PhoneFormatException;
    
    CountryCode identifyCountryCode(String number, boolean force) throws PhoneFormatException;
}
