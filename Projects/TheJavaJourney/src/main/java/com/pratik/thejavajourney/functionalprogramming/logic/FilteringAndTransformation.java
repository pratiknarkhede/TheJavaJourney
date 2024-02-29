package com.pratik.thejavajourney.functionalprogramming.logic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pratik.thejavajourney.functionalprogramming.pojo.Customer;
import com.pratik.thejavajourney.utils.JsonUtils;
import lombok.SneakyThrows;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


/**
 * <p>
 * program using Streams to filter customers based on their purchase history and
 * transform them into a Map where the key is the customer's name and
 * the value is their total spending amount.
 * </p> *
 */
public class FilteringAndTransformation {
    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Customer> customers = objectMapper.readValue(new File("src/main/resources/inputs/customer.json"), new TypeReference<List<Customer>>() {
        });
        JsonUtils.printJson(customers);


        Map<String, Long> customerCounts = customers.stream()
                                                    .filter(customer -> customer.getPurchaseHistory()
                                                                                .stream()
                                                                                .mapToDouble(Double::doubleValue)
                                                                                .sum() > 100) // Filter by total purchase
                                                    .collect(groupingBy(Customer::getName, Collectors.counting())); // Group and count occurrences by name

        System.out.println(customerCounts);

        Map<String, Long> collect = customers.stream()
                                             .filter(customer -> customer.getPurchaseHistory()
                                                                         .stream()
                                                                         .mapToDouble(Double::doubleValue)
                                                                         .sum() > 100)
                                             .collect(groupingBy(Customer::getName, mapping(customer -> customer.getPurchaseHistory(), counting())));
        System.out.println(collect);

        //Given a list of customers, use Streams to find the top 3 customers with the highest total purchase amounts and
        // create a Map<String, Double> showing their names and corresponding total spending amounts.



        Map<String, Double> topCustomers = customers.stream()
                                                    // Map each customer to a pair of their name and their total purchase amount
                                                    .map(customer -> new AbstractMap.SimpleEntry<>(
                                                            customer.getName(),
                                                            customer.getPurchaseHistory().stream().mapToDouble(Double::doubleValue).sum()))
                                                    // Sort the stream of entries by total purchase amount in descending order
                                                    .sorted(Comparator.comparing(AbstractMap.SimpleEntry<String, Double>::getValue).reversed())
                                                    // Limit the results to the top 3
                                                    .limit(3)
                                                    // Collect the results into a map
                                                    .collect(Collectors.toMap(
                                                            AbstractMap.SimpleEntry::getKey, // Name as key
                                                            AbstractMap.SimpleEntry::getValue, // Total purchase amount as value
                                                            (oldValue, newValue) -> oldValue, // In case of a key collision, keep the old value
                                                            LinkedHashMap::new));

        System.out.println(topCustomers);
    }


}



