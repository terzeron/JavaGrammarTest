package net.terzeron.test.abstract_factory_pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class PhoneNumber {
    private String phoneNumber;

    abstract String getCountryCode();

}
