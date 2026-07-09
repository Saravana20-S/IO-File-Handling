package com.bridgelabz.fileio;

/**
 * Model class representing an Employee.
 */
public class EmployeePayrollData {

    // Employee ID
    private int id;

    // Employee Name
    private String name;

    // Employee Salary
    private double salary;

    /**
     * Parameterized constructor.
     *
     * @param id Employee ID
     * @param name Employee Name
     * @param salary Employee Salary
     */
    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /**
     * Returns employee details in readable format.
     */
    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}