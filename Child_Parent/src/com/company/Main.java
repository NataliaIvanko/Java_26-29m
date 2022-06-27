package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	Child child = new Child("a", "a");
    Parent parent = new Parent("b", "b");
    Parent child1 = new Child("c", "c");
    Parent child2 = child;
       // System.out.println(child.getfName());
     //   System.out.println(child1.getfName());


    Parent[] ar = {child, parent};
        System.out.println("before: " + ar[0].getlName());
        System.out.println(ar[1].getlName());

        child.setlName("gdkfhgöxfdlk");
        System.out.println("after: " + ar[0].getlName());

        List<String> h = new ArrayList<>();

    }
}
