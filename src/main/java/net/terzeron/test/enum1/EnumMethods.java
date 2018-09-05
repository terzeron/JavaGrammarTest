package net.terzeron.test.enum1;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class EnumMethods {
    public static void main(String[] args) {
        Laptops rated = Laptops.DELL;
        System.out.println("Using enum method to get the rating of laptop.");
        System.out.println();

        switch (rated) {
            case SONY:
                System.out.println(Laptops.SONY.getRating());
                break;
            case HP:
                System.out.println(Laptops.HP.getRating());
                break;
            case DELL:
                System.out.println(Laptops.DELL.getRating());
                break;
        }
    }

    @AllArgsConstructor
    @Getter
    public enum Laptops {
        SONY(1), HP(2), DELL(3);
        private int rating;

    }
}
