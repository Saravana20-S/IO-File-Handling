package com.bridgelabz.fileio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Test class for Employee Payroll File Service.
 */
public class EmployeePayrollFileServiceTest {

    private static final Path PAYROLL_FILE =
            Paths.get("TempPlayGround", "EmployeePayroll.txt");

    /**
     * Tests printing employee payroll from the file.
     */
    @Test
    public void givenEmployeePayrollDataWhenPrintedShouldMatchEntries()
            throws IOException {

        List<EmployeePayrollData> employeeList = List.of(
                new EmployeePayrollData(101, "Raj", 45000),
                new EmployeePayrollData(102, "Amit", 50000),
                new EmployeePayrollData(103, "Priya", 60000)
        );

        EmployeePayrollFileService service =
                new EmployeePayrollFileService();

        // Write employee payroll to file
        service.writeEmployeePayroll(employeeList, PAYROLL_FILE);

        // Print employee payroll
        service.printEmployeePayroll(PAYROLL_FILE);

        // Count entries
        long entries = FileEntryCounter.countEntries(PAYROLL_FILE);

        System.out.println("\nNumber of Entries : " + entries);

        Assertions.assertEquals(employeeList.size(), entries);
    }
}   