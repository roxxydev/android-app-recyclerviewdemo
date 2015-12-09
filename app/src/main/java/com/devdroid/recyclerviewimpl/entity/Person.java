package com.devdroid.recyclerviewimpl.entity;

import java.util.ArrayList;
import java.util.List;

public class Person {

    public String name;
    public String age;
    public String imgUrl;

    public Person(String name, String age, String imgUrl) {
        this.name = name;
        this.age = age;
        this.imgUrl = imgUrl;
    }

    public static List<Person> getPersonsData() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "18 years old",
                "http://www.telegraph.co.uk/content/dam/fashion/2015-08/aug26/emma-watson-lead-x-large.jpg"));
        persons.add(new Person("Bill Gates", "55 years old",
                "http://stanlemmens.nl/wp/wp-content/uploads/2014/07/bill-gates-wealthiest-person.jpg"));
        persons.add(new Person("Adam Sandler", "49 years old",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSnN-F2yxTgPv--fNtqcRkyJNkLI0qRc5ZVncArHp5YfJg2NGnz6w"));
        return persons;
    }

}
