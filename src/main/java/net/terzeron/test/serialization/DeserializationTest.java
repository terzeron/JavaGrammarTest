package net.terzeron.test.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by terzeron on 2017. 9. 13..
 */
public class DeserializationTest {
    public static void main(String[] args) {
        DeserializationTest deserializer = new DeserializationTest();
        Employee employee = deserializer.deserializeEmployee();
        System.out.println(employee);
    }

    public Employee deserializeEmployee() {
        Employee employee;

        try {
            FileInputStream filein = new FileInputStream("employee.ser");
            ObjectInputStream objis = new ObjectInputStream(filein);
            employee = (Employee) objis.readObject();
            objis.close();
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
