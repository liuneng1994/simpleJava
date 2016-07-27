package com.hand.ln.mybatis.model;

public class Employee {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private Integer salary;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "[employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
                + salary + "]";
    }

}
