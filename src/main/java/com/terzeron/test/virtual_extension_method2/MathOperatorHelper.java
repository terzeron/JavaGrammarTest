package com.terzeron.test.virtual_extension_method2;

/**
 * Created by terzeron on 2017. 10. 23..
 */
class MathOperatorHelper {
    public static int findProduct(int a, int b) {
        System.out.println("finding product by multiplying");
        return a * b;
    }

    public static int findProductUsingSum(int a, int b) {
        int product = 0;
        System.out.println("finding product by interative sum");
        for (int i = 0; i < b; i++) {
            product += a;
        }
        return product;
    }
}
