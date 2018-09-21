package com.gerald.comsciexploration.challenges;

import static com.gerald.comsciexploration.challenges.ShortPalindromeSolver.howManyQuadrupulePalindromeTupules;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ShortPalindromeSolverTest {

    @ParameterizedTest
    @MethodSource("argumentSource")
    void palindromeCalculation(String string, long result) {
        assertThat(howManyQuadrupulePalindromeTupules(string),
                is(equalTo(result)));
    }

    static Stream<Arguments> argumentSource(){
        return Stream.of(
                arguments("kkkkkkz", 15L),
                arguments("ghhggh", 4L),
                arguments("abbaab", 4L),
                arguments("akakak", 2L)
        );
    }
}