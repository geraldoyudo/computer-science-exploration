package com.gerald.comsciexploration.challenges;

import com.gerald.comsciexploration.algorithms.linkedlist.Cell;
import com.gerald.comsciexploration.algorithms.linkedlist.LinkedListLoopBreaker;
import java.util.Hashtable;

public class HashTableLinkedListLoopBreaker implements LinkedListLoopBreaker {

    @Override
    public <T> Cell<T> breakLoopPoint(Cell<T> top) {
        return useHashTableToBreakLoopPoint(top);
    }

    static <T> Cell<T> useHashTableToBreakLoopPoint(Cell<T> top){
        Hashtable<Cell<T>, Boolean> visitedMap = new Hashtable<>();
        Cell<T> current = top.getNext();
        Cell<T> previous = null;
        while(current != null){
            if (visitedMap.containsKey(current)){
                previous.setNext(null);
                return current;
            }
            visitedMap.put(current, true);
            previous = current;
            current = current.getNext();
        }
        return null;
    }
}
