package com.company;

public class MyDate implements Comparable<MyDate> {
    private int day;
    private int month;
    private int year;


    public MyDate(int day, int month, int year) {
        if (month >12 || month <1) month = 1;
        if (day>31 || day <1) day = 1;
        if (year < 1) year = 1;
        this.day = day;
        this.month = month;
        this.year = year;

    }
    public MyDate(String s) {

        String[] values = s.split("-");
        day = Integer.parseInt(values[0]);
        month = Integer.parseInt(values[1]);
        year = Integer.parseInt(values[2]);
/*
        if (month >12 || month <1) month = 1;
        if (day>31 || day <1) day = 1;*/
 /*
        this.day = day;
        this.month = month;
        this.year = 2022;

  */
    }
    public int compareTo(MyDate myDate){
   //     return this.day- myDate.day; //только по числам

        if(this.year != myDate.getYear()) {
            return this.year - myDate.getYear();
        }else if(this.month != myDate.getMonth()) {
            return this.month - myDate.getMonth();
        } else {
            return this.day - myDate.getDay();
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return  day + "-" + month + "-"+ year;
    }
}
