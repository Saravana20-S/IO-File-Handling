# Employee IO

A Java Maven project demonstrating Employee Payroll operations using Java File I/O (NIO) and JUnit 5. The project implements file handling functionalities through incremental use cases, including reading, writing, monitoring, and analyzing employee payroll data.

## Project Structure

```text
EmployeeIO
│── pom.xml
│
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── bridgelabz
    │               ├── employeeIO
    │               └── fileio
    │
    └── test
        └── java
            └── com
                └── bridgelabz
                    ├── employeeIO
                    └── fileio
```

## Use Cases Implemented

### UC1 - Employee Payroll Service
- Created `EmployeePayrollData` class with employee details:
    - Employee ID
    - Employee Name
    - Employee Salary
- Read employee payroll details from the console.
- Display employee payroll details on the console.

### UC2 - Java File Operations
Implemented File I/O operations using the Java NIO API:
- Check file or directory existence.
- Delete existing files/directories.
- Create directories.
- Create empty files.
- List files and directories.
- Filter files based on file extension.

### UC3 - Watch Service and File Entry Count
- Implemented Java NIO Watch Service.
- Monitored a directory and its sub-directories for:
    - File creation
    - File modification
    - File deletion
- Counted the number of entries in a file.

### UC4 - Write Employee Payroll to File
- Created employee payroll objects.
- Stored employee payroll data in a text file using Java NIO.
- Verified the write operation by counting the number of file entries.

### UC5 - Print Employee Payroll and Show Entry Count
- Read employee payroll records from the payroll file.
- Printed payroll records to the console.
- Displayed the total number of entries present in the payroll file.

### UC6 - Read Employee Payroll File
- Read employee payroll records from the payroll file.
- Converted file data back into `EmployeePayrollData` objects.
- Loaded payroll records into memory for further processing and analysis.
- Verified the number of employee records read from the file.

## Technologies Used

- Java
- Maven
- Java NIO File API
- WatchService API
- JUnit 5

## Key Concepts

- Object-Oriented Programming
- Java File I/O
- Java NIO
- Watch Service
- File Handling
- Stream API
- Unit Testing using JUnit 5

## Branch Strategy

```text
main
│
└── dev
    ├── feature/UC1ReadWriteEmployeePayroll
    ├── feature/UC2FileOperationsUsingNIO
    ├── feature/UC3WatchServiceAndCountFileEntries
    ├── feature/UC4WriteEmployeePayrollToFile
    ├── feature/UC5PrintEmployeePayrollFromFile
    └── feature/UC6ReadEmployeePayrollFile
```

## How to Run

1. Clone the repository.
2. Open the project using IntelliJ IDEA.
3. Build the Maven project.
4. Run the required JUnit test cases or execute the main class for console-based operations.

## Author

**Saravanan S**