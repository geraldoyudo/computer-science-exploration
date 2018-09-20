package com.gerald.comsciexploration.algorithms.arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FourDimensionalArrayTest {

    private NDimensionArray<Integer> array;

    @BeforeEach
    void setUp(){
        array = NDimensionArray.<Integer>builder()
                .bounds(1, 10, 5, 10, 2, 5, 50, 100)
                .defaultValue(0)
                .build();
    }

    @CsvSource({
            "3, 1, 5, 2, 50",
            "100, 1, 10, 2, 50",
            "50, 1, 10, 5, 50",
            "67, 1, 10, 5, 100",
            "42, 10, 10, 5, 100",
            "1882, 5, 6, 3, 60"
    })
    @ParameterizedTest
    void accessingValueInRangeShouldBeSuccessful(int result, int firstDimension, int secondDimension,
            int thirdDimension, int fourthDimension){
        array.set(result, firstDimension, secondDimension, thirdDimension, fourthDimension);
        assertThat(array.get(firstDimension, secondDimension, thirdDimension, fourthDimension), is(equalTo(result)));
    }

    @CsvSource({
            "3, -1, 5, 2, 50",
            "100, 1, 11, 2, 50",
            "50, 1, 10, 1, 50",
            "67, 1, 10, 5, 400",
            "42, 10, 10, -1, 20",
            "1882, 0, 15, 3, 60"
    })
    @ParameterizedTest
    void accessingValueOutOfRangeShouldThrowArrayIndexOutOfBoundsException(int result,
            int firstDimension, int secondDimension, int thirdDimension, int fourthDimension){
        assertAll("Should throw ArrayIndexOutOfBoundsException",
                () -> assertThrows(ArrayIndexOutOfBoundsException.class,
                        () -> array.set(result, firstDimension, secondDimension, thirdDimension, fourthDimension)),
                () -> assertThrows(ArrayIndexOutOfBoundsException.class,
                        () -> array.get(firstDimension, secondDimension, thirdDimension, fourthDimension))
        );
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenAccessingWithWrongNumberOfDimensions(){
        assertAll("Should throw ArrayIndexOutOfBoundsException",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> array.set(3, 1, 2000, 5)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> array.set(3, 1, 32, 42, 42, 42)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> array.get(1, 2000, 5)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> array.get(1, 20, 32, 32, 42))
        );
    }

}
