package com.terzeron.test.virtual_extension_method2;

/**
 * Created by terzeron on 2017. 10. 23..
 */
interface SpecialMathOperator extends MathOperator {
    default int findProduct(int a, int b) {
        return MathOperatorHelper.findProductUsingSum(a, b);
    }
}

