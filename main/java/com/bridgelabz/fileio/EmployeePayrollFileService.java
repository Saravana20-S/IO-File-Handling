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
     * @param employees List of employee payroll data
     * @param filePath Employee payroll file path
     * @throws IOException if writing fails
     */
    public void writeEmployeePayroll(List<EmployeePayrollData> employees,
                                     Path filePath) throws IOException {

        // Create parent directory if it doesn't exist
        if (Files.notExists(filePath.getParent())) {
            Files.createDirectories(filePath.getParent());
        }

        Files.write(filePath,
                employees.stream()
                        .map(EmployeePayrollData::toString)
                        .toList());
    }
}