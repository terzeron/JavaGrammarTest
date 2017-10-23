package net.terzeron.test.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by terzeron on 2017. 9. 13..
 */
public class SerializationTest {
    public static void main(String args[]) {
        SerializationTest serializer = new SerializationTest();
        serializer.serializeEmployee("Krishna", "India");
    }

    public void serializeEmployee(String name, String id) {
        Employee address = new Employee();
        address.setName(name);
        address.setEmpId(id);

        try {
            FileOutputStream fileout = new FileOutputStream("employee.ser");
            ObjectOutputStream objout = new ObjectOutputStream(fileout);
            objout.writeObject(address);
            objout.close();
            System.out.println("Serialization to object is completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
