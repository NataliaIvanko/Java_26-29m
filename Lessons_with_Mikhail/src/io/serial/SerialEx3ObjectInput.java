package io.serial;

import io.employees.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerialEx3ObjectInput {
    public static void main(String[] args) {
        Employee newEmp;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("emp2000.bin"))){
            newEmp=(Employee) inputStream.readObject();
            System.out.println(newEmp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
