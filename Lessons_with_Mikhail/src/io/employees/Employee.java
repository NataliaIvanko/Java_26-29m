package io.employees;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;

import java.io.Serializable;

/*

@Getter
@ToString

 */
@AllArgsConstructor

public class Employee implements Serializable {
    static final long serialVersionUID = 1;
    String name;
    String lastName;
    String department;
  //  int age;
// transient  double salary; //скрытый
    Car car;

    public Employee(String name, String lastName, String department, int age, Car car) {
        this.name = name;
        this.lastName = lastName;
        this.department = department;
       // this.age = age;

        this.car = car;
    }

    public Employee(String name, String department, int age, double salary) {
        this.name = name;
        this.department = department;
    //    this.age = age;
    //    this.salary = salary;

    }

    public Car getCar() {
        return car;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

  //  public int getAge() {
 //       return age;
   // }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
              //  ", age=" + age +

                ", car=" + car +
                '}';
    }
}
