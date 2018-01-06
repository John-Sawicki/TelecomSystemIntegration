package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.telecomsystemintegration;

public class CalcHours {
    String[][] weeklyHours = new String[5][4];
    double[] dailyTotal = new double[5];
    double weekTotal;


    CalcHours(String[][] weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public double[] HoursWorkedPerDay() {
        //convert all the String array values to double
        //for each row (day) determine the number of hours worked
        //dailyTotal[0]
        dailyTotal[1]=0; dailyTotal[2]=0; dailyTotal[3]=0; dailyTotal[4]=0;
        return dailyTotal;
    }
    public double WeekTotal(){      //add up hte total for all 5 days
        for(int i=0;  i<5; i++){
            weekTotal = dailyTotal[i];
        }
        return weekTotal;
    }
    public String timeToGo(){       //determine the time when hours worked equals 40
        return "300";
    }
}
