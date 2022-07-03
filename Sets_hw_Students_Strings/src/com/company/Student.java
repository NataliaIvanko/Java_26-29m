package com.company;

public class Student implements Comparable<Student>{
    private String name;
    private int tasksDone;

    public Student(String name, int tasksDone) {
        this.name = name;
        this.tasksDone = tasksDone;
    }

    public String getName() {
        return name;
    }

    public int getTasksDone() {
        return tasksDone;
    }

    @Override
    public String toString() {
        return
                name + " "+ tasksDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (tasksDone != student.tasksDone) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + tasksDone;
        return result;

    }

    @Override
    public int compareTo(Student o){
        if(getTasksDone() > o.getTasksDone()) return 1;
        else if(getTasksDone() < o.getTasksDone()) return -1;
        else return 0;
    }
}
