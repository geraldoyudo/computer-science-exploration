package com.gerald.comsciexploration.algorithms.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OneDimensionalCustomArrayTest {
    private OneDimensionalCustomArray<Integer> oneDimensionalCustomArray;

    @BeforeEach
    void setUp(){
        oneDimensionalCustomArray = new OneDimensionalCustomArray<>(1,
                new Integer []{1, 2, 3});
    }

    @Test
    void indexShouldBeCorrect(){
        assertAll("Indexes should be correct",
                () -> assertEquals((Integer) 1, oneDimensionalCustomArray.get(1)),
                () -> assertEquals((Integer) 2, oneDimensionalCustomArray.get(2)),
                () -> assertEquals((Integer) 3, oneDimensionalCustomArray.get(3)));
    }

    @Test
    void arrayIndexOutOfBoundsExceptionShouldBeThrownIfIndexIsOutOfRange(){
        assertAll("ArrayIndexOutOfBoundsException should be thrown",
                () -> assertThrows(ArrayIndexOutOfBoundsException.class, () -> oneDimensionalCustomArray.get(0)),
                () -> assertThrows(ArrayIndexOutOfBoundsException.class, () -> oneDimensionalCustomArray.get(4)));
    }
}