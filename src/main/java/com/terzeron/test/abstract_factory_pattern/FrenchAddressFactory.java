package com.terzeron.test.abstract_factory_pattern;

public class FrenchAddressFactory implements AddressFactory {
    public Address createAddress() {
        return new FrenchAddress();
    }

    public PhoneNumber createPhoneNumber() {
        return new FrenchPhoneNumber();
    }
}