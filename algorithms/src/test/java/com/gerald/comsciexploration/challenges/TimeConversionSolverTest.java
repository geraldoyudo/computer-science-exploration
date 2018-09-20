package com.gerald.comsciexploration.challenges;

import static com.gerald.comsciexploration.challenges.TimeConversionSolver.convertTimeTo24Hours;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TimeConversionSolverTest {

    @ParameterizedTest
    @MethodSource("argumentSource")
    void timeConversion(String twelveHourTime, String result) {
        assertThat(convertTimeTo24Hours(twelveHourTime), is(equalTo(result)));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                arguments("07:05:45PM", "19:05:45"),
                arguments("12:00:00AM", "00:00:00"),
                arguments("12:00:00PM", "12:00:00"),
                arguments("07:05:45AM", "07:05:45")
        );
    }
}