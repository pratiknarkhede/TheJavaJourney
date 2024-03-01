package com.pratik.thejavajourney.functionalprogramming.logic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pratik.thejavajourney.functionalprogramming.pojo.Customer;
import com.pratik.thejavajourney.utils.JsonUtils;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingAndCounting {

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Customer> customers = objectMapper.readValue(new File("src/main/resources/inputs/customer.json"), new TypeReference<List<Customer>>() {
        });
        //JsonUtils.printJson(customers);

        //getting count of total records after counting
        Integer collect = customers.stream()
                                   .collect(Collectors.collectingAndThen(Collectors.groupingBy(Customer::getName), map -> map.size()));
        System.out.println(collect);

        //per group count
        Map<String, Long> groupedEmployeesCountOnName = customers.stream()
                                              .collect(Collectors.groupingBy(Customer::getName, Collectors.counting()));
        System.out.println(groupedEmployeesCountOnName);

    }
}
