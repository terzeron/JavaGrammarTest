package net.terzeron.test.class_loader;

public class ClassLoaderTest {
    public static void main(String[] args) {
        try {
            System.out.println("before loading by loadClass()");
            ClassLoader.getSystemClassLoader().loadClass("net.terzeron.test.class_loader.TestClass");
            // not initialized
            System.out.println("after loading by loadClass()");

            System.out.println("before loading by forName()");
            Class.forName("net.terzeron.test.class_loader.TestClass");
            System.out.println("after loading by forName()");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
