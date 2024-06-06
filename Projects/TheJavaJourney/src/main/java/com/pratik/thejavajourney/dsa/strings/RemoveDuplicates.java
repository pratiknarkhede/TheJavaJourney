package com.pratik.thejavajourney.dsa.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class RemoveDuplicates {

    public static void main(String[] args) {
        String s = "this is a example string having duplicates characters";
        s = removeDuplicates(s);
        System.out.println(s);

    }


    /**
     * The type Remove duplicates.
     * <p>
     * create linkedHashSet and not normal hash set because linkedHashSet maintains order of insertion
     * <p>
     * then create a list of string and add it to linkedHashSet to remove duplicates
     * <p>
     * afterward add each element of linkedHashSet to string builder
     */
    private static String removeDuplicates(String s) {
        LinkedHashSet<String> uniqueCharacters = new LinkedHashSet<>();
        String[] split = s.split("");
        uniqueCharacters.addAll(Arrays.asList(split));
        StringBuilder sb = new StringBuilder();
        for (String str : uniqueCharacters) {
            sb.append(str);
        }
        String filteredString = sb.toString();
        return filteredString;
    }
}
