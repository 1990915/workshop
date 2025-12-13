package com.misc.methodRef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Geeks {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Vicky", 24));
        personList.add(new Person("Poonam", 25));
        personList.add(new Person("Sachin", 19));

        // A comparator class with multiple
        // comparator methods
        ComparisonProvider comparator = new ComparisonProvider();

        // Now using instance method reference
        // to sort array by name
        Collections.sort(personList, comparator::compareByName);

        System.out.println("Sort by Name :");

        // Using streams
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);

        System.out.println();

        // Using instance method reference
        // to sort array by age
        personList.sort(comparator::compareByAge);

        // Display message only
        System.out.println("Sort by Age :");

        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);
    }
}