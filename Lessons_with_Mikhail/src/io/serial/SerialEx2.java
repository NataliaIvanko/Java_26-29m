package io.serial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerialEx2 {
    public static void main(String[] args) {
        List<String> employees;

        try(ObjectInputStream inputStream = //wrapper
                    new ObjectInputStream(new FileInputStream("emplEx.bin"))){
           employees = (ArrayList) inputStream.readObject();
            System.out.println(employees);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    }

