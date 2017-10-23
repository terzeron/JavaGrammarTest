package net.terzeron.test.class_name;

/**
 * Created by terzeron on 2016. 8. 11..
 */
public class GetObjectClassName {
    public static void main(String[] args) {
        Class<?> classVar = null;
        String str = "Test String";
        classVar = str.getClass();
        System.out.println("Class name 1: " + classVar.getName());

        classVar = int.class;
        System.out.println("Class Name 2: " + classVar.getName());

        classVar = int[].class;
        System.out.println("Class name 3: " + classVar.getName());

        classVar = Void.TYPE;
        System.out.println("Class name 4: " + classVar.getName());

        classVar = Enum.class;
        System.out.println("Class name 5: " + classVar.getName());

    }
}
