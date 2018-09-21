package com.gerald.comsciexploration.algorithms.arrays;

import static com.gerald.comsciexploration.algorithms.arrays.TriangularArray.MirrorEntryHandlingStrategy
        .RETURN_DEFAULT_VALUE;
import static com.gerald.comsciexploration.algorithms.arrays.TriangularArray.MirrorEntryHandlingStrategy
        .RETURN_MIRROR_VALUE;
import static com.gerald.comsciexploration.algorithms.arrays.TriangularArray.MirrorEntryHandlingStrategy
        .THROW_EXCEPTION;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gerald.comsciexploration.algorithms.arrays.TriangularArray.MirrorEntryHandlingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class TriangularArrayTest {

    @CsvSource({
            "1, 1",
            "2, 3",
            "3, 6",
            "4, 10",
            "5, 15"
    })
    @ParameterizedTest
    void triangularArrayShouldHaveCorrectSize(int rowSize, int arraySize){
        TriangularArray<Integer> array = TriangularArray.<Integer>
                builder()
                    .rowSize(rowSize)
                    .defaultValue(0)
                    .build();
        assertThat(array.size(), is(equalTo(arraySize)));
    }

    @ParameterizedTest
    @MethodSource("valuesAboveDiagonal")
    void givenThrowExceptionMirrorHandlingStrategyWhenAccessingEntriesAboveDiagonalThenThrowException(int result,
            int row, int column){
        TriangularArray<Integer> array = createIntegerArrayWithStrategy(4, THROW_EXCEPTION);
        assertAll("Should Throw ArrayIndexOutOfBoundsException",
                () -> assertThrows(ArrayIndexOutOfBoundsException.class,
                        () -> array.set(result, row, column)),
                () -> assertThrows(ArrayIndexOutOfBoundsException.class,
                        () -> array.get(row, column)));
    }

    private TriangularArray<Integer> createIntegerArrayWithStrategy(int rowSize, MirrorEntryHandlingStrategy strategy){
        return TriangularArray.<Integer>
                builder()
                .rowSize(rowSize)
                .defaultValue(0)
                .handleMirrorEntries(strategy)
                .build();
    }

    static Integer [][] valuesAboveDiagonal(){
        return new Integer [][]{
                {1, 0, 1},
                {11, 0, 2},
                {12, 1, 2},
                {50, 0, 3},
                {10, 1, 3},
                {5, 2, 3}
        };
    }

    @ParameterizedTest
    @MethodSource("valuesAboveDiagonal")
    void givenDefaultValueMirrorHandlingStrategyWhenAccessingEntriesAboveDiagonalThenReturnDefaultValue(int result,
            int row, int column){
        TriangularArray<Integer> array = createIntegerArrayWithStrategy(4, RETURN_DEFAULT_VALUE);
        array.set(result, row, column);
        assertThat(array.get(row, column), is(equalTo(0)));
    }

    @ParameterizedTest
    @MethodSource("valuesAboveDiagonal")
    void givenMirrorValueMirrorHandlingStrategyWhenAccessingEntriesAboveDiagonalThenReturnMirrorValue(int result,
            int row, int column){
        TriangularArray<Integer> array = createIntegerArrayWithStrategy(4, RETURN_MIRROR_VALUE);
        assertAll(() -> {
                    array.set(result, row, column);
                    assertSymmetrical(result, row, column, array);
                },
                () -> {
                    array.set(result, column, row);
                    assertSymmetrical(result, row, column, array);
                });
    }

    private void assertSymmetrical(int result, int row, int column, TriangularArray<Integer> array) {
        assertThat(array.get(row, column), is(equalTo(result)));
        assertThat(array.get(column, row), is(equalTo(result)));
    }

    @Nested
    class GivenFixedTriangularArray {
        private TriangularArray<Integer> array;

        @BeforeEach
        void setUp() {
            array =  TriangularArray.<Integer>
                    builder()
                    .rowSize(4)
                    .defaultValue(0)
                    .build();
        }

        @CsvSource({
                "10, 0, 0",
                "1, 1, 0",
                "20, 1, 1",
                "11, 2, 0",
                "12, 2, 1",
                "-1, 2, 2",
                "50, 3, 0",
                "10, 3, 1",
                "5, 3, 2",
                "-20, 3, 3",
        })
        @ParameterizedTest
        void shouldBeAbleToAccessAllIndexesOfTriangularArray(int result, int row, int column) {
            array.set(result, row, column);
            assertThat(array.get(row, column), is(equalTo(result)));
        }

        @CsvSource({
                "10, 4, 4",
                "1, -1, 0",
                "20, 1, -1",
                "11, 2, 10",
                "12, 10, 10"
        })
        @ParameterizedTest
        void shouldThrowArrayIndexOutOfBoundsExceptionWhenRowAndColumnExceedsRowSize(int result, int row, int column) {
            assertAll("Should Throw ArrayIndexOutOfBoundsException",
                    () -> assertThrows(ArrayIndexOutOfBoundsException.class,
                            () -> array.set(result, row, column)),
                    () -> assertThrows(ArrayIndexOutOfBoundsException.class,
                            () -> array.get(row, column)));
        }
    }
}