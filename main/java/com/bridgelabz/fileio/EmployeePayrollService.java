package com.bridgelabz.fileio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Service class to read and write employee payroll data.
 */
public class EmployeePayrollService {

    /**
     * Different IO Services.
     * (Other types will be used in future use cases.)
     */
    public enum IOService {
        CONSOLE_IO,
        FILE_IO,
        DB_IO,
        REST_IO
    }

    // Stores employee payroll records.
    private List<EmployeePayrollData> employeePayrollList;

    /**
     * Default constructor.
     */
    public EmployeePayrollService() {
    }

    /**
     * Parameterized constructor.
     *
     * @param employeePayrollList List of employees
     */
    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    /**
     * Reads employee information from console.
     *
     * @param consoleInputReader Scanner object
     */
    private void readEmployeePayrollData(Scanner consoleInputReader) {

        System.out.print("Enter Employee ID : ");
        int id = consoleInputReader.nextInt();

        System.out.print("Enter Employee Name : ");
        String name = consoleInputReader.next();

        System.out.print("Enter Employee Salary : ");
        double salary = consoleInputReader.nextDouble();

        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    /**
     * Displays employee payroll data.
     */
    private void writeEmployeePayrollData() {

        System.out.println("\nEmployee Payroll Details");

        for (EmployeePayrollData employee : employeePayrollList) {
            System.out.println(employee);
        }
    }

    /**
     * Main method.
     */
    public static void main(String[] args) {

        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

        EmployeePayrollService employeePayrollService =
                new EmployeePayrollService(employeePayrollList);

        Scanner scanner = new Scanner(System.in);

        employeePayrollService.readEmployeePayrollData(scanner);

        employeePayrollService.writeEmployeePayrollData();

        scanner.close();
    }
}