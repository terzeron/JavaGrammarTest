package net.terzeron.test.abstract_factory_pattern;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        Address address = new USAddressFactory().createAddress();
        System.out.println("US Address:" + address.getFullAddress());
    }
}
