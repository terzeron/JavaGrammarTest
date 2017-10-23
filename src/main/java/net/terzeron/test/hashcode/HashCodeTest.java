package net.terzeron.test.hashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by terzeron on 2016. 4. 7..
 */
public class HashCodeTest {
    public static void main(String[] args) {
        Map<EmployeeId, Employee> employees = new HashMap<EmployeeId, Employee>();
        employees.put(new EmployeeId("111"), new Employee("Johny"));
        employees.put(new EmployeeId("222"), new Employee("Jeny"));
        employees.put(new EmployeeId("333"), new Employee("Jessie"));
        Employee emp = employees.get(new EmployeeId("222"));
        System.out.println(emp);
    }
}
