package com.gerald.comsciexploration.challenges;

/**
 * Problem description
 * https://www.hackerrank.com/challenges/short-palindrome/problem
 */
public class ShortPalindromeSolver {
    private static final int MAX = 1_000_000_007;

    static long howManyQuadrupulePalindromeTupules(String string){
        long count = 0;
        int length = string.length();
        for(int a = 0; a < length - 3; ++ a){
            for(int d = length -1; d >= a + 3; --d){
                if(string.charAt(a) == string.charAt(d)){
                    char desiredChar = string.charAt(a);
                    String tupuleBoundary = string.substring(a, d + 1);
                    for(int b = a + 1; b < d-1; ++b){
                        for(int c = b +1; c < d; ++ c){
                            if(string.charAt(b) == string.charAt(c)){
                                count = count +1;
                                if(count == (MAX)){
                                    count = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
