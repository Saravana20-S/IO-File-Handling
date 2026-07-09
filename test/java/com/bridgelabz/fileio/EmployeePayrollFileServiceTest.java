package com.bridgelabz.fileio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Test class for EmployeePayrollFileService.
 */
public class EmployeePayrollFileServiceTest {

    /**
     * Payroll file location.
     */
    private static final Path PAYROLL_FILE =
            Paths.get("TempPlayGround", "EmployeePayroll.txt");

    /**
     * Tests writing employee payroll to a file and verifies entry count.
     */
    @Test
    public void givenEmployeePayrollDataWhenWrittenToFileShouldMatchEntries()
            throws IOException {

        List<EmployeePayrollData> employeeList = List.of(
                new EmployeePayrollData(101, "Raj", 45000),
                new EmployeePayrollData(102, "Amit", 50000),
                new EmployeePayrollData(103, "Priya", 60000)
        );

        EmployeePayrollFileService service =
                new EmployeePayrollFileService();

        service.writeEmployeePayroll(employeeList, PAYROLL_FILE);

        long entries = FileEntryCounter.countEntries(PAYROLL_FILE);

        System.out.println("Number of Entries : " + entries);

        Assertions.assertEquals(employeeList.size(), entries);
    }
}