package com.company;

import java.util.List;

public class Students {
    private String name;
    private List<Integer> score;

    public Students(String name, List<Integer> score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return  name + " " +score;
    }

    public String getName() {
        return name;
    }

    public double getGPA(){
        if(score==null || score.isEmpty()) return 0;
       double res = 0;
        for (Integer i: score) {
           if(i!=null) res +=i;

        }
        return 1.0*res/score.size();
    }
}
