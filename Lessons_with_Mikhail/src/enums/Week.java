package enums;

import static enums.Week.*;

public  enum Week { //
    MONDAY("bad"),
    TUESDAY("bad"),
    WEDNESDAY("so so"),
    THURSDAY("so so"),
    FRIDAY("good"),
    SATURDAY("great"),
    SUNDAY("good");

    private String mood;

    Week(String mood) {
        this.mood = mood;
    }


    public String getMood() {
        return mood;
    }

}
class Today {
    Week week;

    public Today(Week week) {
        this.week = week;
    }

    public Week getWeek() {
        return week;
    }

    void getDay() {
        switch (week) {
            case MONDAY:
                THURSDAY:
                    TUESDAY:
                    FRIDAY:
                    WEDNESDAY: System.out.println("Study Java");
                break;
            case SATURDAY:
                SUNDAY: System.out.println("relax");
                break;
        }
        System.out.println(week.getMood());
    }
    //switch (spin.getSelectedItem()) {
    //    case "first option":
    //    case "second option":
    //    case "third option":
    //        result = 1;
    //        break;
    //    /** rest of the code here
}

