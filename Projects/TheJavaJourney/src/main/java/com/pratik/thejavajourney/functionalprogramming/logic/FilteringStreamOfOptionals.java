package com.pratik.thejavajourney.functionalprogramming.logic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
* how to filter out non-empty values from a Stream of Optionals. we explore below
* */


public class FilteringStreamOfOptionals {

    public static void main(String[] args) {
        List<Optional<String>> listOfOptionals = Arrays.asList(
                Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar"));

        solution1(listOfOptionals);
        //using java 9 optional stream
        solution2(listOfOptionals);

        Optional<String> s = Optional.of("test");
        System.out.println(Optional.of("TEST"));
        System.out.println( s.map(String::toUpperCase));

    }

    private static void solution2(List<Optional<String>> listOfOptionals) {
        List<String> filteredStream2 = listOfOptionals.stream()
                                                      .flatMap(o -> o.stream())
                                                      .collect(Collectors.toList());
        System.out.println(filteredStream2);
    }

    private static void solution1(List<Optional<String>> listOfOptionals) {
        List<String> filteredStream1 = listOfOptionals.stream()
                                                      .filter(optnl -> optnl.isPresent())
                                                      .map(optnl -> optnl.get())
                                                      .collect(Collectors.toList());

        System.out.println(filteredStream1);
    }
}
