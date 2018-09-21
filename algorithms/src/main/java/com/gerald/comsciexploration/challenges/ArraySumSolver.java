package com.gerald.comsciexploration.challenges;

/**
 * Problem description:
 * https://www.hackerrank.com/challenges/simple-array-sum/problem
 */
public class ArraySumSolver {

    public int sumArray(int... elements) {
        int sum = 0;
        for (int element : elements) {
            sum += element;
        }
        return sum;
    }
}
