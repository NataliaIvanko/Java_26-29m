package enums;

import java.util.Arrays;

public class Test1 {
    /*
    void method(String s){
        System.out.println("Today is " + s);
    }

     */


    public static void main(String[] args) {
        Test1 test1 = new Test1();
    //    test1.method("Hi");
        Week w5 = Week.FRIDAY;
        Week w1 = Week.MONDAY;
        Week w2 = Week.TUESDAY;
        Week w4 = Week.THURSDAY;
        Week w6 = Week.SATURDAY;

        Week22 w55 = Week22.FRIDAY;
        System.out.println(w55.equals(w5));//false, different data types

      //  Week newWeek = Week.valueOf("Weeks"); //you want to make enum from a string
        //but we have already  defined enums, FRIDay - also illegal arg exc
      //  System.out.println(newWeek);
        Week newWeek1 = Week.valueOf("FRIDAY"); // we can do it like that
        Week[] array = Week.values();//returns array containing enums
      //  System.out.println(Arrays.toString(array));

        Today today = new Today(Week.FRIDAY);
        today.getDay();

        if(today.getWeek()==Week.FRIDAY){ //if data types are different, equals will not work, e.g. Week22 instead of Week
            System.out.println("Today is Friday");
        }else System.out.println("Today is " + today.week);
/*
        if(Browser.MOZILLA){
            System.out.println();
        }else{

        }


 */
    }

}
