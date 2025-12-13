package com.misc.methodRef;

// Helper class Comparator class
class ComparisonProvider {
    // To compare with name
    public int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }

    // To compare with age
    public int compareByAge(Person a, Person b) {
        return a.getAge().compareTo(b.getAge());
    }
}
