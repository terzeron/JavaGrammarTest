package net.terzeron.test.mutability;

import java.util.Date;

/**
 * Created by terzeron on 2016. 8. 29..
 */
public class Employee {
    public static void main(String[] args) {
        EmployeeMut emp = new EmployeeMut("Emp1", new Date(), 1000.00);
        System.out.println(emp.getName());
        System.out.println(emp.getSalaryDate());
    }
}
