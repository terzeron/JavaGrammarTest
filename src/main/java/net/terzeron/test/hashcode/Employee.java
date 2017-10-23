package net.terzeron.test.hashcode;

/**
 * Created by terzeron on 2016. 4. 7..
 */
public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    // equals를 재정의해야 hashmap에 대해 name이 동일한 객체로 검색하는 것이 가능해짐
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;

        }
        if (obj.getClass() != getClass()) {
            return false;
        }

        Employee emp = (Employee) obj;
        if (this.name == emp.name) {
            return true;
        }
        return false;
    }

    // hash function을 재정의 - name을 가지고 hashing
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
