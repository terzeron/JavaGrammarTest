package com.terzeron.grammar.abstract_factory_pattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    @Test
    public void testGetFullAddress() {
        Address address = new USAddressFactory().createAddress();
        address.setCity("Chicago");
        address.setPostalCode("10581");
        address.setRegion("South East");
        address.setStreet("Mulberry Avenue");

        assertEquals(address.getFullAddress(), "Mulberry Avenue\n" +
                "Chicago, South East 10581\n" +
                "United States\n");
    }
}
