package com.gerald.comsciexploration.challenges;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CompareTheTripletsSolverTest {

    private CompareTheTripletsSolver solver = new CompareTheTripletsSolver();

    @ParameterizedTest
    @MethodSource("argumentSource")
    void compareTriplets(int[] first, int[] second, int[] result) {
        assertThat(solver.compareTriplets(first, second), is(equalTo(result)));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(arguments(array(3, 2, 1), array(1, 2, 3), array(1, 1)),
                arguments(array(4, 3, 3), array(4, 3, 3), array(0, 0)),
                arguments(array(10, 9, 9), array(7, 6, 5), array(3, 0)),
                arguments(array(3, 2, 1), array(5, 8, 7), array(0, 3)),
                arguments(array(0, 0, 0), array(0, 0, 0), array(0, 0)));
    }

    private static int[] array(int... elements) {
        return elements;
    }
}