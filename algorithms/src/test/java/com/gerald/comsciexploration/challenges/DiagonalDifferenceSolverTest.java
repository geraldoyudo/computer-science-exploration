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

class DiagonalDifferenceSolverTest {

    private DiagonalDifferenceSolver solver = new DiagonalDifferenceSolver();

    @ParameterizedTest
    @MethodSource("argumentSource")
    void calculateDiagonalDifference(int sum, int[][] array) {
        assertThat(solver.calculateDiagonalDifference(array), is(equalTo(sum)));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                arguments(3,
                        new int [][] {
                                {1, 2, 3},
                                {3, 2, 1},
                                {4, 2, 3}
                        }),
                arguments(15,
                        new int [][] {
                                {11, 2, 4},
                                {4, 5, 6},
                                {10, 8, -12}
                        })
        );
    }
}