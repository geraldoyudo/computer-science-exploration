package com.gerald.comsciexploration.challenges;

public class CellUtils {

    static  <T> void copy(Cell<T> sourceList, Cell<T> destinationList){
        Cell<T> sourceItem = sourceList.getNext();
        Cell<T> destinationItem = destinationList;
        while (sourceItem != null){
            Cell<T> newValue = new Cell<>(sourceItem.getValue());
            destinationItem.setNext(newValue);
            destinationItem = newValue;
            sourceItem = sourceItem.getNext();
        }
    }

    static <T> Cell<T> initializeList(Cell<T> sentinel, T... values) {
        Cell<T> previouslyAdded = sentinel;
        Cell<T> added;
        for (T value : values) {
            added = new Cell<>(value);
            previouslyAdded.setNext(added);
            previouslyAdded = added;
        }
        return sentinel;
    }

    static <T> int size(Cell<T> sentinel){
        Cell<T> current = sentinel;
        int count = 0;
        while (current.getNext() != null){
            current = current.getNext();
            count ++;
        }
        return count;
    }

    static <T> Cell<T> getLast(Cell<T> sentinel){
        Cell<T> current = sentinel;
        while (current.getNext() != null){
            current = current.getNext();

        }
        return current;
    }
}
