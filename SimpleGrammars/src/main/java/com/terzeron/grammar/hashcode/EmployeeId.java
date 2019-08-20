package com.terzeron.grammar.hashcode;

/**
 * Created by terzeron on 2016. 4. 7..
 */
public class EmployeeId {
    private String id;

    public EmployeeId(String id) {
        this.id = id;
    }

    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != getClass()) {
            return false;
        }
        EmployeeId empId = (EmployeeId) obj;
        return this.id == empId.id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
