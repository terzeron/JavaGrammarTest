package net.terzeron.test.class_for_name;

/**
 * Created by terzeron on 2016. 8. 11..
 */
public class ClassForNameTest {
    public static void main(String[] args) {
        try {
            // explicitly load class using forName()
            Class.forName("net.terzeron.test.class_for_name.One");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }

        try {
            // wrong way of specifying class name
            // It must be fully qualified path
            Class.forName("Two");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }

        try {
            // explicitly load class using forName()
            Class.forName("net.terzeron.test.class_for_name.Two");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }

        // create instance
        new Three();
    }
}

class One {
    static {
        System.out.println("class One loaded");
    }
}

class Two {
    static {
        System.out.println("class Two loaded");
    }
}

class Three {
    static {
        System.out.println("class Three loaded");
    }
}
