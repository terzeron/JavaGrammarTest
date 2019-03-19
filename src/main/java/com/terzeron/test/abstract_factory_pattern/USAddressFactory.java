package com.terzeron.test.abstract_factory_pattern;

public class USAddressFactory implements AddressFactory {
    public Address createAddress() {
        return new USAddress();
    }

    public PhoneNumber createPhoneNumber() {
        return new USPhoneNumber();
    }
}
