package com.gerald.comsciexploration.algorithms.linkedlist;

import static com.gerald.comsciexploration.algorithms.linkedlist.CellUtils.initializeList;
import static com.gerald.comsciexploration.algorithms.linkedlist.LinkedListTest.loopListAt;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

interface LinkedListLoopBreakerTest {

    @Test
    default void testMarkedAlgorithm() {
        Cell<Integer> unLoopedList = initializeList(new Cell<>(-1), 1, 2, 3, 4, 5);
        Cell<Integer> loopedList = initializeList(new Cell<>(-1), 1, 2, 3, 4, 5);
        loopListAt(2, loopedList);
        LinkedListLoopBreaker loopBreaker = getLoopBreaker();
        assertThat(loopBreaker.breakLoopPoint(unLoopedList), nullValue());
        Cell<Integer> loopPoint = loopBreaker.breakLoopPoint(loopedList);
        assertThat(loopPoint, notNullValue());
        assertThat(loopPoint.getValue(), is(equalTo(2)));
    }

    LinkedListLoopBreaker getLoopBreaker();
}