package com.gerald.comsciexploration.challenges;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ArraySumSolverTest {

    private ArraySumSolver solver = new ArraySumSolver();

    @ParameterizedTest
    @MethodSource("sumAndElements")
    void sumShouldBeCorrect(int[] sumAndElements) {
        int sum = sumAndElements[0];
        int[] elements = Arrays.copyOf(sumAndElements, 1);
        assertThat(solver.sumArray(elements), is(equalTo(sum)));
    }

    static Stream<Arguments> sumAndElements() {
        return Stream.of(
                arguments(new int[] {10, 2, 3, 4, 1}),
                arguments(new int[] {0, 0, 0, 0, 0}),
                arguments(new int[] {0, 0}),
                arguments(new int[] {2, 2}),
                arguments(new int[] {3, 5, -10, 1, 1, 3})
        );
    }
}