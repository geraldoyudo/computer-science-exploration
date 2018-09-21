package com.gerald.comsciexploration.algorithms.arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NDimensionArrayTest {

    @Test
    void throwIllegalArgumentExceptionIfBoundsNotEven(){
        assertThrows(IllegalArgumentException.class, () ->
            NDimensionArray
                    .<Integer>builder()
                    .bounds(2, 3, 4)
                    .defaultValue(0)
                    .build()
        );
    }

    @Nested
    class WhenCorrectArrayCreated {
        private NDimensionArray<Integer> array;

        @BeforeEach
        void setUp(){
            array = NDimensionArray.<Integer>builder()
                    .bounds(1, 10, 2000, 2010)
                    .defaultValue(0)
                    .build();
        }

        @CsvSource({
                "3, 1, 2000",
                "100, 10, 2010",
                "50, 10, 2000",
                "67, 1, 2010",
                "42, 5, 2005",
                "1882, 2, 2007"
        })
        @ParameterizedTest
        void accessingValueInRangeShouldBeSuccessful(int result, int firstDimension, int secondDimension){
            array.set(result, firstDimension, secondDimension);
            assertThat(array.get(firstDimension, secondDimension), is(equalTo(result)));
        }

        @CsvSource({
                "3, 1, 1999",
                "100, 12, 2010",
                "50, 10, 50",
                "67, 0, 3000",
                "42, 5, -4000",
                "1882, -1, 2007"
        })
        @ParameterizedTest
        void accessingValueOutOfRangeShouldThrowArrayIndexOutOfBoundsException(int result,
                int firstDimension, int secondDimension){
            assertAll("Should throw ArrayIndexOutOfBoundsException",
                        () -> assertThrows(ArrayIndexOutOfBoundsException.class,
                                () -> array.set(result, firstDimension, secondDimension)),
                        () -> assertThrows(ArrayIndexOutOfBoundsException.class,
                            () -> array.get(firstDimension, secondDimension))
                            );
        }

        @Test
        void shouldThrowIllegalArgumentExceptionWhenAccessingWithWrongNumberOfDimensions(){
            assertAll("Should throw ArrayIndexOutOfBoundsException",
                    () -> assertThrows(IllegalArgumentException.class,
                            () -> array.set(3, 1, 2000, 5)),
                    () -> assertThrows(IllegalArgumentException.class,
                            () -> array.set(3, 1)),
                    () -> assertThrows(IllegalArgumentException.class,
                            () -> array.get(1, 2000, 5)),
                    () -> assertThrows(IllegalArgumentException.class,
                            () -> array.get(1))
            );
        }
    }

}