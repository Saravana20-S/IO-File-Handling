package com.bridgelabz.fileio;

/**
 * Represents an Employee Payroll record.
 */
public class EmployeePayrollData {

    private int id;
    private String name;
    private double salary;

    /**
     * Parameterized Constructor.
     */
    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + salary;
    }
}