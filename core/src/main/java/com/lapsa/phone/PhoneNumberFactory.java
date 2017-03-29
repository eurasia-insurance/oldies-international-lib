package com.lapsa.phone;

public interface PhoneNumberFactory {

    PhoneNumber parse(String raw);

    PhoneNumber parse(String raw, boolean strict);

    PhoneNumber parse(String raw, CountryCode defaultCountryCode);

    CountryCode identifyCountryCode(String number, boolean force) throws PhoneFormatException;

    PhoneNumber create(CountryCode country, String number);

    PhoneNumber create(CountryCode country, String number, String raw);
}
