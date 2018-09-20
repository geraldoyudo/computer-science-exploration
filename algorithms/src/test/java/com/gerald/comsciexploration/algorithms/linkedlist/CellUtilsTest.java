package com.gerald.comsciexploration.algorithms.linkedlist;

import static com.gerald.comsciexploration.algorithms.linkedlist.CellUtils.initializeList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CellUtilsTest {

    @Test
    void copy() {
        Cell<Integer> linkedListOne = initializeList(sentinel(), 1, 2, 3, 4, 5);
        Cell<Integer> destinationList = initializeList(sentinel());
        CellUtils.copy(linkedListOne, destinationList);
        assertEquals(CellUtils.size(linkedListOne), CellUtils.size(destinationList));
        for (int i = 0; i < 5; ++i) {
            Cell<Integer> sourceItem = linkedListOne.getNext();
            Cell<Integer> destinationItem = linkedListOne.getNext();
            assertEquals(sourceItem.getValue(), destinationItem.getValue());
        }
    }

    @Test
    void size() {
        assertEquals(5, CellUtils.size(initializeList(sentinel(), 1, 2, 3, 4, 5)));
    }

    private Cell<Integer> sentinel() {
        return new Cell<>(-1);
    }

    @Test
    void getLast() {
        assertEquals((Integer) 5, CellUtils.getLast(initializeList(sentinel(), 1, 2, 3, 4, 5)).getValue());
    }
}