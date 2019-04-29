package com.terzeron.grammar.abstract_factory_pattern;

public interface AddressFactory {
    Address createAddress();
    PhoneNumber createPhoneNumber();
}

