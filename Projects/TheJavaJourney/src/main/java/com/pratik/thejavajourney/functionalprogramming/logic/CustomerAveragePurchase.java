package com.pratik.thejavajourney.functionalprogramming.logic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pratik.thejavajourney.functionalprogramming.pojo.Customer;
import com.pratik.thejavajourney.utils.JsonUtils;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerAveragePurchase {

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Customer> customers = objectMapper.readValue(new File("src/main/resources/inputs/customer.json"), new TypeReference<List<Customer>>() {
        });
        //JsonUtils.printJson(customers);



        Map<String, Double> customerWithAverageSalary = customers.stream()
                                                                 .map(customer -> new AbstractMap.SimpleEntry<>(
                                                                         customer.getName(),
                                                                         customer.getPurchaseHistory()
                                                                                 .stream()
                                                                                 .mapToDouble(Double::doubleValue)
                                                                                 .average()
                                                                                 .orElse(0.0)
                                                                 ))
                                                                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(customerWithAverageSalary);


    }

}
