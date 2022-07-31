package com.company;

public class Person {
    private String name;
    private MyDate birthday;

    public Person(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }


    public String getName() {
        return name;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return name + " "+ birthday;
    }
}
