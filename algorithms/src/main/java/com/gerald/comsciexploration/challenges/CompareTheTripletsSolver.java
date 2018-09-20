package com.gerald.comsciexploration.challenges;

/**
    Problem description:
    https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class CompareTheTripletsSolver {

    int[] compareTriplets(int[] first, int[] second){
        int [] result = new int [] {0, 0};
        for(int i=0; i < 3; ++i ){
            if(first[i] > second[i]){
                result[0]++;
            }else if (second[i] > first [i]){
                result[1]++;
            }
        }
        return result;
    }
}
