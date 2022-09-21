package com.company;

import java.util.List;

public class Faculty {
    private String name;
    List<Student> students;

    public Faculty(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Faculty: " +
                name + " " +
                students;
    }
}
