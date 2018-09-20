package com.gerald.comsciexploration.algorithms;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StepIteratorTest {

    private StepIterator<Integer> stepIterator;

    @BeforeEach
    void setUp() {
        stepIterator = new StepIterator<>(2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Nested
    class WhenNew {

        @Test
        void currentShouldThrowException() {
            assertThrows(IllegalStateException.class, stepIterator::current);
        }

        @Test
        void firstShouldMoveCursorToFirstElment() {
            stepIterator.first();
            assertThat(stepIterator.current(), is(equalTo(1)));
        }

        @Test
        void lastShouldMoveCursorToSecondElement() {
            stepIterator.last();
            assertThat(stepIterator.current(), is(equalTo(10)));
        }

        @Test
        void isDoneShouldBeFalse() {
            assertThat(stepIterator.done(), is(equalTo(false)));
        }
    }

    @Nested
    class WhenNextIsCalled {

        @BeforeEach
        void setUp() {
            stepIterator.first();
        }

        @ParameterizedTest
        @MethodSource("com.gerald.comsciexploration.algorithms.StepIteratorTest#parametersForNextTest")
        void returnRequiredElement(int numberOfNextCalls, int elementValue) {
            IntStream.range(0, numberOfNextCalls).forEach((value) -> stepIterator.next());
            assertThat(stepIterator.current(), is(equalTo(elementValue)));
        }

        @Test
        void whenNextCalledFiveTimesNoElementShouldBeReturned() {
            IntStream.range(0, 5).forEach((value) -> stepIterator.next());
            assertAll("No Element Should be returned",
                    () -> assertThat(stepIterator.done(), is(equalTo(true))),
                    () -> assertThrows(IllegalStateException.class, stepIterator::current));
        }
    }

    static Stream<Arguments> parametersForNextTest() {
        return Stream.of(arguments(1, 3), arguments(2, 5), arguments(3, 7), arguments(4, 9));
    }

    @Nested
    class WhenPreviousIsCalled {

        @BeforeEach
        void setUp() {
            stepIterator.last();
        }

        @ParameterizedTest
        @MethodSource("com.gerald.comsciexploration.algorithms.StepIteratorTest#parametersForPreviousTest")
        void returnRequiredElement(int numberOfNextCalls, int elementValue) {
            stepIterator.last();
            IntStream.range(0, numberOfNextCalls).forEach((value) -> stepIterator.previous());
            assertThat(stepIterator.current(), is(equalTo(elementValue)));
        }

        @Test
        void whenLastCalledFiveTimesNoElementShouldBeReturned() {
            IntStream.range(0, 5).forEach((value) -> stepIterator.previous());
            assertThrows(IllegalStateException.class, stepIterator::current);
        }
    }

    public static Stream<Arguments> parametersForPreviousTest() {
        return Stream.of(arguments(1, 8), arguments(2, 6), arguments(3, 4), arguments(4, 2));
    }
}
