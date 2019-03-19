package com.terzeron.test.abstract_class2;

/**
 * Created by terzeron on 15. 10. 22..
 */
public class BadPoint {
    int x;
    int y;

    void move(int dx, int dy) throws BadPointException {
        x += dx;
        y += dy;
    }

}
