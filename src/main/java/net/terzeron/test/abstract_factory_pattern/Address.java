package net.terzeron.test.abstract_factory_pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Address {
    private String street;
    private String city;
    private String region;
    private String postalCode;

    public static final String EOL_STRING = System.getProperty("line.separator");
    public static final String SPACE = " ";

    public abstract String getCountry();

    public String getFullAddress() {
        return street + EOL_STRING + city + SPACE + postalCode + EOL_STRING;
    }
}
