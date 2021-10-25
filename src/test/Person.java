package test;

import java.util.HashSet;
import java.util.TreeSet;

public class Person {

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        Person firstPerson = new Person(1, "test");
        Person secondPerson = new Person(1, "test");

        boolean result = firstPerson == secondPerson;
        System.out.println("==:"+result);

        boolean result1 = firstPerson.equals(secondPerson);
        System.out.println("equals:"+result1);

        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(firstPerson);
        hashSet.add(secondPerson);

        System.out.println("Hashset size:"+hashSet.size());

        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(firstPerson);
        treeSet.add(secondPerson);

        System.out.println("treeSet size:"+treeSet.size());


    }



}
