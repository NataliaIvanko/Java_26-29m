package com.company;

public class Student {
    private String firstName;
    private String lastName;
    private Double rate;

    public Student(String firstName, String lastName, Double rate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rate = rate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getRate() {
        return rate;
    }


    @Override
    public String toString() {
        return  firstName + " " +
                lastName + " " + rate;
    }
}
