package com.company;

import com.company.exceptions.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private List<Exception>errors;

    public User(String str) throws Exception {
        String[] arr = str.split(";");

        List<Exception> errors = new ArrayList<>();


        try{
            emptyField(str);
        }
        catch(EmptyFieldException efe){
            errors.add(efe);
        }
        try{
            stringFormat(str);
        }catch(InvalidFormatException ife){
            errors.add(ife);
        }
        try{
            numberOfFields(str);
        }
        catch(WrongNumberOfFields wnf){
            errors.add(wnf);
        }
        try{
            checkEmail(str);
        }
        catch (InvalidEmailFormat iee){
            errors.add(iee);
        }
        try{
            checkAge(str);
        }
        catch(InvalidAgeException ie){
            errors.add(ie);
        }
        catch (IllegalArgumentException e){
            errors.add(e);
        }
        if(errors.size() == 0){
            this.firstName = arr[0];
            this.lastName = arr[1];
          this.age=Integer.parseInt(arr[2]);
            this.email = arr[3];

        }else{

            System.out.println(errors);
        }
    }

    private boolean emptyField(String str) throws EmptyFieldException {
        String[]parts = str.split(";");
        for(String s : parts){
            if(s.equals("") || s == null){

                throw new EmptyFieldException("The field " + s + "is empty");
            }
        }
        return true;
    }


    private boolean stringFormat(String str) throws InvalidFormatException {
        String[]parts = str.split(";");
        if((!parts[0].matches("^[a-zA-Z]*$"))&&(!parts[1].matches("^[a-zA-Z]*$"))&&(!parts[2].matches("^[a-zA-Z]*$"))) {
            throw new InvalidFormatException("The format is incorrect");
        }
        return true;
    }


    private boolean numberOfFields(String str) throws WrongNumberOfFields {
        String[]parts = str.split(";");
        if(parts.length> 4){
            throw new WrongNumberOfFields("Too many fields created");
        }
        if(parts.length<4){
            throw new WrongNumberOfFields("Not enough fields created");
        }
        return true;
    }


    public boolean checkEmail(String str) throws InvalidEmailFormat {
        String[]parts = str.split(";");
        if((parts[3].length()<4)|| (!parts[3].contains("@"))){
            throw new InvalidEmailFormat("Incorrect email format");
        }
        return true;
    }


    private boolean checkAge(String str)throws InvalidAgeException {
        String[]parts = str.split(";");
        if(this.age < 0 || this.age > 110){
            throw new InvalidAgeException("Invalid age");
        }
       try{
           this.age = Integer.parseInt(parts[2]);
       }
       catch(NumberFormatException e){
           throw new IllegalArgumentException("Age is invalid");
       }
       return true;
    }





    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
