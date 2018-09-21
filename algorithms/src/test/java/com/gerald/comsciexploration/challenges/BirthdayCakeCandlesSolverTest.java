package com.gerald.comsciexploration.challenges;

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

class BirthdayCakeCandlesSolverTest {

    @ParameterizedTest
    @MethodSource("argumentSource")
    void birthdayCakeCandles(int[] candles, int result) {
        assertThat(BirthdayCakeCandlesSolver.birthdayCakeCandles(candles),
                is(equalTo(result)));
    }

    static Stream<Arguments> argumentSource(){
        return Stream.of(
            arguments(array(3, 2, 1, 3), 2 ),
            arguments(array(2, 2, 1, 3), 1 ),
            arguments(array(10, 10, 10, 10), 4 ),
            arguments(array(3, 2, 3, 3), 3 )
        );
    }

    private static int[] array(int... arrays){
        return arrays;
    }
}