package io.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerialEx1 {
    public static void main(String[] args) {
        List<String> employee = new ArrayList<>();
        employee.add("John");
        employee.add("Nick");
        employee.add("Jack");
        employee.add("Jane");

        try(ObjectOutputStream outputStream = //wrapper
                new ObjectOutputStream(new FileOutputStream("emplEx.bin"))){
            outputStream.writeObject(employee);
            System.out.println("DONE");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
