package net.terzeron.test.code_source;

import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * Created by terzeron on 2016. 8. 11..
 */
public class CodeSourceTest {
    public static void main(String[] args) {
        Class<?> cls = new CodeSourceTest().getClass();
        ProtectionDomain pDomain = cls.getProtectionDomain();
        CodeSource cSource = pDomain.getCodeSource();

        // 클래스로부터 클래스 파일의 위치를 알려줌
        URL location = cSource.getLocation();
        System.out.println("location: " + location);
    }
}
