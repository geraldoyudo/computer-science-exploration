package com.geral.comsciexploration.algorithms.junit5learning;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("First Junit Test Class")
class FirstJunitTests {

    @Test
    @DisplayName("My First Junit Test")
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void standardAssertions() {
        assertEquals(2, 2);
        assertEquals(4, 4, "message");
        assertTrue('a' < 'b', () -> "Should be less");
    }

    @Test
    void groupedAssertions() {
        assertAll("person", () -> assertEquals("John", "John", "No Error"), () -> assertEquals("Peter", "Peter"));
    }

    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }

    @Test
    void assertTimeoutNotExceeded() {
        assertTimeout(Duration.ofMillis(300), () -> {
            // perform task
        });
    }

    @Test
    void assertTimeoutNotExceededWithResult() {
        String result = assertTimeout(Duration.ofMillis(200), () -> {
            return "result";
        });

        assertEquals("result", result);
    }

    @Test
    void usingHamcrest() {
        assertThat(2 + 1, is(equalTo(3)));
    }

    @Disabled
    @Test
    void disabledTest() {

    }

    @EnabledOnOs(OS.MAC)
    @Test
    void runOnMacOnly() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void runOnWindowsOnly() {

    }

    @Test
    void reportValue(TestReporter testReporter) {
        testReporter.publishEntry("A status message");
    }

    @RepeatedTest(name = "My RepeatedTest {currentRepetition}/{totalRepetitions}", value = 10)
    void repeatedTest(){

    }

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    void parameterTest(String candidate) {
        assertThat(candidate, is(equalTo(candidate)));
    }

    @ParameterizedTest
    @MethodSource("range")
    void testWithRangeMethodSource(int argument){
        assertNotEquals(0, argument);
    }

    static IntStream range() {
        return IntStream.range(0, 20).skip(10);
    }
}
