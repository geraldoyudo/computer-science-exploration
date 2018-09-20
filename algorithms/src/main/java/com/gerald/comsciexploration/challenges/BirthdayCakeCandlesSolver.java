package com.gerald.comsciexploration.challenges;

/**
 * Problem description:
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */
public class BirthdayCakeCandlesSolver {

    static int birthdayCakeCandles(int[] array) {
        int candlesThatCanBeBlown = 0;
        int highestCandleHeight = array[0];
        for(int candleHeight: array){
            if(candleHeight > highestCandleHeight ){
                candlesThatCanBeBlown = 1;
                highestCandleHeight = candleHeight;
            }else if( candleHeight == highestCandleHeight){
                candlesThatCanBeBlown++;
            }
        }
        return candlesThatCanBeBlown;
    }

}
