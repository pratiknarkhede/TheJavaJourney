package com.pratik.thejavajourney.functionalprogramming.pojo;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    int id ;
    String name;
    String department;
    double salary;
    List<String> projects;

    public List<Employee> createEmployeeData(){
        return Arrays.asList(
                new Employee(1, "Alice", "Engineering", 75000, Arrays.asList("ProjectA", "ProjectB")),
                new Employee(2, "Bob", "Engineering", 80000, Arrays.asList("ProjectB", "ProjectC")),
                new Employee(3, "Charlie", "HR", 50000, Arrays.asList("ProjectD")),
                new Employee(4, "Diana", "Engineering", 90000, Arrays.asList("ProjectA", "ProjectE")),
                new Employee(5, "Evan", "Sales", 60000, Arrays.asList("ProjectF", "ProjectG")),
                new Employee(6, "Fiona", "HR", 55000, Arrays.asList("ProjectD", "ProjectH")),
                new Employee(7, "George", "Sales", 70000, Arrays.asList("ProjectG")),
                new Employee(8, "Hannah", "Engineering", 85000, Arrays.asList("ProjectE", "ProjectI")),
                new Employee(9, "Ian", "Marketing", 65000, Arrays.asList("ProjectJ")),
                new Employee(10, "Jane", "Sales", 75000, Arrays.asList("ProjectF", "ProjectK"))

        );


    }

    @Override
    public String toString() {
        return String.format("Employee ID: %d\t" +"Name: %s\t" +"Department: %s\t" +"Salary: %.2f\t" +"Projects: %s \n",
                id, name, department, salary, projects);
    }
}
