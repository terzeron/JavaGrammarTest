package lambda;

import java.util.Date;

public class Person {
    String firstName;
    String lastName;
    Date dateOfBirth;
    String placeOfBirth;

    public Person(String fName, String lName, Date dob, String place) {
        firstName = fName;
        lastName = lName;
        dateOfBirth = dob;
        placeOfBirth = place;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
