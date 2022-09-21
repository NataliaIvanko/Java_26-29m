package com.company;

public class Student {
    private String name;
    private String gender;
    private int age;
    private int course;
    private double avgGrade;

    public Student(String name, String gender, int age, int course, double avgGrade) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getCourse() {
        return course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    @Override
    public String toString() {
        return  name + ": " +
                gender + ", " +
                "age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade;
    }
}
