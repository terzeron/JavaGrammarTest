package net.terzeron.test.serialization;

import java.io.Serializable;

/**
 * Created by terzeron on 2017. 9. 13..
 */
public class Employee implements Serializable {
    private String name;
    private String empId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String toString() {
        String str = "Name : " + this.name + ", ID : " + this.empId;
        return str;
    }
}