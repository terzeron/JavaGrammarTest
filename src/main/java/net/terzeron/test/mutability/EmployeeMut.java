package net.terzeron.test.mutability;

import java.util.Date;

/**
 * Created by terzeron on 2016. 8. 29..
 */
// 1) 객체를 immutable로 만들려면 클래스를 public 대신 final로 선언해야 함
final class EmployeeMut {
    // 객체를 immutable로 만들려면 멤버변수를 private final로 선언해야 함
    private final String name;
    private final Date salaryDate;
    private final Double salary;

    public EmployeeMut(String name, Date salaryDate, Double salary) {
        this.name = name;
        // 객체를 immutable로 만들려면 mutable 멤버변수를 복사해서 써야 함
        this.salaryDate = new Date(salaryDate.getTime());
        this.salary = salary;
    }

    // 2) 객체를 immutable로 만들려면 생성자를 private으로 바꾸고 valueOf 메소드를 제공해야 함
    /*
    private EmployeeMut(String name, Date salaryDate, Double salary) {
        this.name = name;
        this.salaryDate = salaryDate;
        this.salary = salary;
    }
    public static EmployeeMut valueOf(String name, Date salaryDate, Double salary) {
        return new EmployeeMut(name, salaryDate, salary);
    }
    Employee mtu = EmployeeMut.valueOf("name", new Date(), 1000.00);
    */

    public String getName() {
        return name;
    }

    public Date getSalaryDate() {
        // 객체를 immutable로 만들려면 mutable 멤버변수를 복사해서 써야 함
        return new Date(this.salaryDate.getTime());
    }

    public Double getSalary() {
        return salary;
    }

    // 객체를 immutable로 만들려면 setter를 제공하면 안 됨
}

