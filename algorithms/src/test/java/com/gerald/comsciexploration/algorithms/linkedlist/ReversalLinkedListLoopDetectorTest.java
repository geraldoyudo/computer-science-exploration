package com.gerald.comsciexploration.algorithms.linkedlist;

import static com.gerald.comsciexploration.algorithms.linkedlist.CellUtils.initializeList;
import static com.gerald.comsciexploration.algorithms.linkedlist.LinkedListTest.loopListAt;
import static com.gerald.comsciexploration.algorithms.linkedlist.LinkedListTest.printLinkedList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ReversalLinkedListLoopDetectorTest {

    private ReversalLinkedListLoopDetector loopDetector = new ReversalLinkedListLoopDetector();

    @Test
    void isLinkedListLooped() {
        Cell<Integer> unLoopedList = initializeList(new Cell<>(-1), 1, 2, 3, 4, 5);
        Cell<Integer> loopedList = initializeList(new Cell<>(-1), 1, 2, 3, 4, 5);
        loopListAt(2, loopedList);
        assertFalse(loopDetector.isLinkedListLooped(unLoopedList));
        assertTrue(loopDetector.isLinkedListLooped(loopedList));
        printLinkedList(unLoopedList);
        printLinkedList(loopedList);
    }
}