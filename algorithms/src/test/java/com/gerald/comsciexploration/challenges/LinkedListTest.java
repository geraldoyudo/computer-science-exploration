package com.gerald.comsciexploration.challenges;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class LinkedListTest {

    private static final String VISITED = "visited";

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
    void testCircularList(){
        Cell<Integer> top = initializeList(1, 2, 3, 4, 5);
        top.getNext().getNext().getNext().getNext().getNext().setNext(top);
        printLinkedList(top);
    }

    private void printLinkedList(Cell<Integer> top) {
        int count = 0;
        Cell<Integer> current = top.getNext();
        while (count < 100 && current != null){
            System.out.println(current.getValue());
            count ++;
            current = current.getNext();
        }
    }

    @Test
    void printLoopWithABranch(){
        Cell<Integer> top = initializeList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        loopListAt(4, top);
        printLinkedList(top);
    }

    static <T> void loopListAt(int index, Cell<T> top){
        int count = 0;
        Cell<T> current = top;
        do{
           current = current.getNext();
           count ++;
        }while (count < index);
        Cell<T> bottom = CellUtils.getLast(top);
        bottom.setNext(current);
    }

    @Test
    void testMarkedAlgorithm(){
        Cell<Integer> unLoopedList = initializeList(1, 2, 3, 4, 5);
        Cell<Integer> loopedList = initializeList(1, 2, 3, 4, 5);
        loopListAt(2, loopedList);
        assertThat(usedMarkedAlgorithmToGetLoopPoint(unLoopedList), nullValue());
        Cell<Integer> loopPoint = usedMarkedAlgorithmToGetLoopPoint(loopedList);
        assertThat(loopPoint, notNullValue());
        assertThat(loopPoint.getValue(), is(equalTo(2)));
        printLinkedList(loopedList);
    }

    static <T> Cell<T> usedMarkedAlgorithmToGetLoopPoint(Cell<T> top){
        Cell<T> current = top.getNext();
        Cell<T> loopPoint = null;
        Cell<T> previous = null;
        while (current != null){
            if(isVisited(current)){
                loopPoint = current;
                previous.setNext(null);
                break;
            }
            markVisited(current);
            previous = current;
            current = current.getNext();
        }
        clearMarks(top);
        return loopPoint;
    }

    static <T> void markVisited(Cell<T> cell){
        cell.setProperty(VISITED, true);
    }

    static <T> boolean isVisited(Cell<T> cell){
        return (boolean) cell.getProperty(VISITED).orElse(false);
    }

    static <T> void clearMarks(Cell<T> top){
        Cell<T> current = top.getNext();
        while (current != null){
            clearVisited(current);
            current = current.getNext();
        }
    }

    static <T> void clearVisited(Cell<T> cell){
        cell.removeProperty("visited");
    }
}