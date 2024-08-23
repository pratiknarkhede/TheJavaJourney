package com.pratik.thejavajourney.collection_framework.comparator.Comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UsePersonComparator {

    public static void main(String[] args) {
        List<Person> listOfPersons = Arrays.asList(new Person("John", 25),
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Diana", 30));

        /*use custom comparator to sort the list*/
        Collections.sort(listOfPersons,new PersonComparator());

        listOfPersons.forEach(System.out::println);
    }
}
