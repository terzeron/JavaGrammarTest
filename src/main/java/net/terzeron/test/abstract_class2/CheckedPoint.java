package net.terzeron.javagrammar;

/**
 * Created by terzeron on 15. 10. 22..
 */
public class CheckedPoint extends BadPoint {
    void move(int dx, int dy) throws BadPointException {
        if ((x + dx) < 0 || (y + dy) < 0) {
            throw new BadPointException();
        }
        x += dx;
        y += dy;
    }
}
