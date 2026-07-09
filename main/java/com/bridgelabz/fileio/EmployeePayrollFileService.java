package com.bridgelabz.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Service class to perform employee payroll file operations.
 */
public class EmployeePayrollFileService {

    /**
     * Writes employee payroll data into a file.
     *
     * @param employees List of employee payroll records
     * @param filePath Payroll file path
     * @throws IOException if writing fails
     */
    public void writeEmployeePayroll(List<EmployeePayrollData> employees,
                                     Path filePath) throws IOException {

        if (Files.notExists(filePath.getParent())) {
            Files.createDirectories(filePath.getParent());
        }

        Files.write(filePath,
                employees.stream()
                        .map(EmployeePayrollData::toString)
                        .toList());
    }

    /**
     * Prints all employee payroll records from the file.
     *
     * @param filePath Payroll file path
     * @throws IOException if reading fails
     */
    public void printEmployeePayroll(Path filePath) throws IOException {

        System.out.println("\nEmployee Payroll Records\n");

        Files.lines(filePath)
                .forEach(System.out::println);
    }
}