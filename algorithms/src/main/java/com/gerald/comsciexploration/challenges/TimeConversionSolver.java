package com.gerald.comsciexploration.challenges;

/**
 * Problem Description:
 * https://www.hackerrank.com/challenges/time-conversion
 */
public class TimeConversionSolver {

    static String convertTimeTo24Hours(String twelveHourTimeInString) {
        String dayMarker = twelveHourTimeInString.substring(8);
        String hourString = twelveHourTimeInString.substring(0, 2);
        String timeWithoutHour = twelveHourTimeInString.substring(2,8);
        if( hourString.equals("12") && dayMarker.equals("PM")){
            hourString = "12";
        }else if( hourString.equals("12") && dayMarker.equals("AM")){
            hourString = "00";
        }else if(dayMarker.equals("PM")){
            hourString = String.format("%02d", Integer.parseInt(hourString) + 12);
        }
        return hourString + timeWithoutHour;
    }
}
