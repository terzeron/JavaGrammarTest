package net.terzeron.test.charset;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by terzeron on 2016. 9. 5..
 */
public class CharSetTest {
    public static void main(String[] args) {
        Map charSets = Charset.availableCharsets();
        int i = 1;
        for (Object name : charSets.keySet()) {
            System.out.println("CharSet " + i + " : " + name);
            i++;
        }
    }
}
