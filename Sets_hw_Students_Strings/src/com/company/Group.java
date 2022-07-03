package com.company;

import java.util.List;

public class Group {
    String title;
    List<Student> student;

    public Group(String title, List<Student> student) {
        this.title = title;
        this.student = student;
    }

    public String getTitle() {
        return title;
    }

    public List<Student> getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return title + " " + student;
    }
}
