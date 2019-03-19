package com.terzeron.test.abstract_factory_pattern;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        Address address = new USAddressFactory().createAddress();
        address.setCity("Chicago");
        address.setPostalCode("10581");
        address.setRegion("South East");
        address.setStreet("Mulberry Avenue");
        System.out.println("US Address:" + address.getFullAddress());
    }
}
