package com.pratik.thejavajourney.functionalprogramming;


import com.pratik.thejavajourney.functionalprogramming.pojo.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsRevision {

    public static void main(String[] args) {
        Employee employee = new Employee();
        List<Employee> employeeData = employee.createEmployeeData();
        //System.out.println(employeeData);

        /*  Employee(id=1, name=Alice, department=Engineering, salary=75000.0, projects=[ProjectA, ProjectB]),
            Employee(id=2, name=Bob, department=Engineering, salary=80000.0, projects=[ProjectB, ProjectC]),
            Employee(id=3, name=Charlie, department=HR, salary=50000.0, projects=[ProjectD]),
            Employee(id=4, name=Diana, department=Engineering, salary=90000.0, projects=[ProjectA, ProjectE]),
            Employee(id=5, name=Evan, department=Sales, salary=60000.0, projects=[ProjectF, ProjectG]),
            Employee(id=6, name=Fiona, department=HR, salary=55000.0, projects=[ProjectD, ProjectH]),
            Employee(id=7, name=George, department=Sales, salary=70000.0, projects=[ProjectG]),
            Employee(id=8, name=Hannah, department=Engineering, salary=85000.0, projects=[ProjectE, ProjectI]),
            Employee(id=9, name=Ian, department=Marketing, salary=65000.0, projects=[ProjectJ]),
            Employee(id=10, name=Jane, department=Sales, salary=75000.0, projects=[ProjectF, ProjectK])]*/

//        filterEmployees(employeeData);
//        ExtractNameOfEmployees(employeeData);
//        totalSalaryOfSalesDepartment(employeeData);
//        findHighestPaidEmployee(employeeData);
//        groupEmployeeByDepartment(employeeData);
//        countEmployeesPerDepartment(employeeData);
//        listAllUniqueProjects(employeeData);
//        partitionEmployeesBasedOnsalary(employeeData);
//        increaseSalaryOfADepartmentByPercent(employeeData);
//        findTop3HighestpaidEngineers(employeeData);
//        safelyRetrieveEmployeesById(employeeData);
//        concatinateAllEmployeeNames(employeeData);
//        obtainSalaryStatistics(employeeData);
//        groupEmployeeByDepartmentThenSalary(employeeData);
        sortEmployeesByDeptThenSalary(employeeData);
    }


    //4. Find the Highest Paid Employee
    private static void findHighestPaidEmployee(List<Employee> employeeData) {
        Optional<Employee> employeeWithHighestSalary = employeeData.stream()
                                                                   .collect(Collectors.maxBy(Comparator.comparing(employee -> employee.getSalary())));

        if (employeeWithHighestSalary.isPresent()) {
            System.out.println("Higest paid employee is :" + employeeWithHighestSalary.get()
                                                                                      .getName());
        }
    }

    //3. Calculate Total Salary for Sales Department
    private static void totalSalaryOfSalesDepartment(List<Employee> employeeData) {
        double sumOfSalary = employeeData.stream()
                                         .filter(employee -> employee.getDepartment() == "Sales")
                                         .mapToDouble(employee -> employee.getSalary())
                                         .sum();
        System.out.println("Total Salary for Sales Department :" + sumOfSalary);
    }

    //1. Retrieve a list of all employees who work in the "Engineering" department.
    public static void filterEmployees(List<Employee> employeeData) {
        List<Employee> filteredEmployees = employeeData.stream()
                                                       .filter(employee -> employee.getDepartment() == "Engineering")
                                                       .collect(Collectors.toList());
        System.out.println("list of all employees who work in the \"Engineering\" department");
        System.out.println(filteredEmployees);
        System.out.println();
    }


    //2. Extract Names of All Employees

    public static void ExtractNameOfEmployees(List<Employee> employeeData) {
        List<String> employeeNameList = employeeData.stream()
                                                    .map(employee -> employee.getName())
                                                    .collect(Collectors.toList());
        System.out.println("Names of All Employees");
        System.out.println(employeeNameList);
        System.out.println();
    }

    //5. Group Employees by Department
    private static void groupEmployeeByDepartment(List<Employee> employeeData) {
        Map<String, List<Employee>> groupedEmployee = employeeData.stream()
                                                                  .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
        System.out.println("group employees by department");
        System.out.println(groupedEmployee);
    }

    //6. Count Employees per Department

    private static void countEmployeesPerDepartment(List<Employee> employeeData) {
        Map<String, Long> countOfEmployeesPerDepartment = employeeData.stream()
                                                                      .collect(Collectors.groupingBy(employee -> employee.getDepartment(), Collectors.counting()));
        System.out.println(countOfEmployeesPerDepartment);
    }
    // 7. List All Unique Projects

    private static void listAllUniqueProjects(List<Employee> employeeData) {

        // this wont work it will give list of list which we will need to flatten instead
/*
        List<List<String>> collect = employeeData.stream()
                                                 .map(employee -> employee.getProjects())
                                                 .distinct()
                                                 .collect(Collectors.toList());
        System.out.println("List Of all unique employeeds : ");
        System.out.println(collect);
*/


        Set<String> listOfAllUnqiueProjects = employeeData.stream()
                                                          .flatMap(employee -> employee.getProjects()
                                                                                       .stream()).
                                                          collect(Collectors.toSet());
        System.out.println("List Of all unique projects : ");
        System.out.println(listOfAllUnqiueProjects);
    }

    //8. Partition Employees by Salary

    private static void partitionEmployeesBasedOnsalary(List<Employee> employeeData) {
        Map<Boolean, List<Employee>> employeePartitionBasedOnSalary = employeeData.stream()
                                                                                  .collect(Collectors.partitioningBy(employee -> employee.getSalary() > 75000));
        System.out.println("employee partition based on salary :");
        System.out.println(employeePartitionBasedOnSalary);
    }

    //9. Increase Salaries for HR Department
    private static void increaseSalaryOfADepartmentByPercent(List<Employee> employeeData) {
        List<Employee> employeeWithRaisedSalary = employeeData.stream()
                                                              .filter(employee -> employee.getDepartment() == "HR")
                                                              .map(employee -> new Employee(employee.getId(), employee.getName(), employee.getDepartment(), employee.getSalary() * 1.1,
                                                                      employee.getProjects()))
                                                              .collect(Collectors.toList());
        System.out.println("Employee with raised Salary");
        System.out.println(employeeWithRaisedSalary);
    }

    //10. Get Top 3 Highest Paid Engineers

    private static void findTop3HighestpaidEngineers(List<Employee> employeeData) {
        List<Employee> top3HighestPaidEngineers = employeeData.stream()
                                                              .filter(employee -> employee.getDepartment()
                                                                                          .equals("Engineering"))
                                                              .sorted(Comparator.comparing((Employee employee) -> employee.getSalary())
                                                                                .reversed())
                                                              // or we can use method reference directly
                                                              //.sorted(Comparator.comparing(Employee::getSalary).reversed())
                                                              // we need casting explicitly to Employee object since is not able to determine type of employee
                                                              .limit(3)
                                                              .collect(Collectors.toList());
        System.out.println("Top 3 highest paid engineers");
        System.out.println(top3HighestPaidEngineers);
    }

    //11. Safely Retrieve Employee by ID : Get the name of the employee with ID 5; return "Unknown" if not found.
    // safely in the since handle unknown situation
    private static void safelyRetrieveEmployeesById(List<Employee> employeeData) {
        String safelyRetreiveEmployeeNameWithId = employeeData.stream()
                                                              .filter(employee -> employee.getId() == 5)
                                                              .map(employee -> employee.getName())
                                                              .findFirst()
                                                              .orElse("Unknown");
        System.out.println("Safely Retrieve Employee by ID : Get the name of the employee with ID 5");
        System.out.println(safelyRetreiveEmployeeNameWithId);
    }

    //12. Concatenate Employee Names : Combine all employee names into a single comma-separated string

    private static void concatinateAllEmployeeNames(List<Employee> employeeData) {
        String combinedEmployeeName = employeeData.stream()
                                                  .map(employee -> employee.getName())
                                                  .collect(Collectors.joining(","));
        System.out.println("Concatenated Employee Names : Combine all employee names into a single comma-separated string");
        System.out.println(combinedEmployeeName);
    }

    //13. Summarize Salary Statistics : Obtain statistics like count, sum, min, max, and average of salaries
    // Requirement: Use Collectors.summarizingDouble.
    private static void obtainSalaryStatistics(List<Employee> employeeData) {
        double sum = employeeData.stream()
                                 .mapToDouble(employee -> employee.getSalary())
                                 .sum();
        OptionalDouble average = employeeData.stream()
                                             .mapToDouble(employee -> employee.getSalary())
                                             .average();
        OptionalDouble min = employeeData.stream()
                                         .mapToDouble(employee -> employee.getSalary())
                                         .min();
        OptionalDouble max = employeeData.stream()
                                         .mapToDouble(employee -> employee.getSalary())
                                         .max();

        DoubleSummaryStatistics doubleSummaryStats = employeeData.stream()
                                                                 .collect(Collectors.summarizingDouble(employee -> employee.getSalary()));
        System.out.println(" Summarized Salary Statistics");
        System.out.println(doubleSummaryStats.toString());


    }


    private static void groupEmployeeByDepartmentThenSalary(List<Employee> employeeData) {
        Map<String, Map<String, List<Employee>>> empGroupedByDeptSalary = employeeData.stream()
                                                                                      .collect(Collectors.groupingBy(Employee::getDepartment,
                                                                                              Collectors.groupingBy(employee -> {
                                                                                                  if (employee.getSalary() < 60000)
                                                                                                      return "<60k";
                                                                                                  else if (employee.getSalary() < 60000 && employee.getSalary() > 40000) {
                                                                                                      return "60k-40k";
                                                                                                  } else return ">80k";
                                                                                              }, Collectors.toList())));

        System.out.println("Employee grouped dept and salaat " + empGroupedByDeptSalary);
    }


    //16. Sort Employees by Department

    public static void sortEmployeesByDeptThenSalary(List<Employee> employeeData) {
        List<Employee> sortedEmployeeByDeptSalary = employeeData.stream()
                                             .sorted(Comparator.comparing(Employee::getDepartment)
                                             .thenComparing(Employee::getSalary)
                                                               .reversed())
                                             .collect(Collectors.toList());
        System.out.println("sorted employee by department then salary "+sortedEmployeeByDeptSalary);
    }

}
