package com.terzeron.pattern;

public class USAddress extends Address {
    public static final String COUNTRY = "United States";
    public static final String COMMA = ",";

    public String getCountry() { return COUNTRY; }

    public String getFullAddress() {
        return getStreet() + EOL_STRING + getCity() + COMMA + SPACE + getRegion() + SPACE + getPostalCode() + EOL_STRING + COUNTRY + EOL_STRING;
    }
}
