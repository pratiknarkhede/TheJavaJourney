package com.pratik.thejavajourney.collection_framework.comparator.Comparator;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int ageComparison = Integer.compare(p1.getAge(), p2.age);
        if(ageComparison !=0){
            return ageComparison;
        }
        //if ages are compare by name

        /*
        *  int compareTo(String anotherString)  compares first string on which the method is called with
        * anotherString passed as argument
        *
        * if base string is lexically first after sorting returns 1 otherwise -1 and 0 for the same
        * */
        return p1.getName().compareTo(p2.getName());
    }
}
