package io.serial;

import io.employees.Car;
import io.employees.Employee;

import java.io.*;

public class SerialEx3ObjectOutput {
    public static void main(String[] args) {
        Car car = new Car ("BMW", "White");
        Employee employee = new Employee("Nick","Wilson", "IT",  22, car);
                        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("emp2000.bin"))){
            outputStream.writeObject(employee);
            System.out.println("DONE");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
