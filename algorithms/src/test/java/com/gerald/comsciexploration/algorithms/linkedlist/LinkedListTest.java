package com.gerald.comsciexploration.algorithms.linkedlist;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void addItem() {
        Cell<Integer> sentinel = initializeList(3);
        assertThat(sentinel.getNext().getValue(), is(equalTo(3)));
    }

    @Test
    void displayItemInLinkedList() {
        Cell<Integer> sentinel = initializeList(1, 2, 3, 4, 5);
        for (Cell<Integer> current = sentinel.getNext(); current != null; current = current.getNext()) {
            System.out.println(current.getValue());
        }
    }

    Cell<Integer> initializeList(Integer... values) {
        return CellUtils.initializeList(new Cell<>(-1), values);
    }

    @Test
    void testCircularList() {
        Cell<Integer> top = initializeList(1, 2, 3, 4, 5);
        top.getNext().getNext().getNext().getNext().getNext().setNext(top);
        printLinkedList(top);
    }

    public static void printLinkedList(Cell<Integer> top) {
        int count = 0;
        Cell<Integer> current = top.getNext();
        while (count < 100 && current != null) {
            System.out.println(current.getValue());
            count++;
            current = current.getNext();
        }
    }

    @Test
    void printLoopWithABranch() {
        Cell<Integer> top = initializeList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        loopListAt(4, top);
        printLinkedList(top);
    }

    static <T> void loopListAt(int index, Cell<T> top) {
        int count = 0;
        Cell<T> current = top;
        do {
            current = current.getNext();
            count++;
        } while (count < index);
        Cell<T> bottom = CellUtils.getLast(top);
        bottom.setNext(current);
    }
}