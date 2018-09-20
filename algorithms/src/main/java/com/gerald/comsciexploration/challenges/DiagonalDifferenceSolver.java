package com.gerald.comsciexploration.challenges;

public class DiagonalDifferenceSolver {

    public int calculateDiagonalDifference(int[][] array){
        int leftRightDiagonalSum = calculateLeftRightDiagonalSum(array);
        int rightLeftDiagonalSum = calculateRightLeftDiagonalSum(array);
        return Math.abs(leftRightDiagonalSum - rightLeftDiagonalSum);
    }

    private int calculateLeftRightDiagonalSum(int [][] array ){
        int sum = 0;
        for(int i = 0, j = 0; i < array.length && j < array.length; i ++, j ++){
            sum += array[i][j];
        }
        return sum;
    }

    private int calculateRightLeftDiagonalSum(int [][] array ){
        int sum = 0;
        for(int i = 0, j = array.length - 1; i < array.length && j >= 0 ; i ++, j --){
            sum += array[i][j];
        }
        return sum;
    }
}
