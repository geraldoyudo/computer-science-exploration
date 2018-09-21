package com.gerald.comsciexploration.algorithms.linkedlist;

public class MarkedAlgorithmLinkedListLoopBreaker implements LinkedListLoopBreaker {
    private static final String VISITED = "visited";

    @Override
    public <T> Cell<T> breakLoopPoint(Cell<T> top) {
        return usedMarkedAlgorithmToGetLoopPoint(top);
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

    private static <T> void markVisited(Cell<T> cell){
        cell.setProperty(VISITED, true);
    }

    private static <T> boolean isVisited(Cell<T> cell){
        return (boolean) cell.getProperty(VISITED).orElse(false);
    }

    private static <T> void clearMarks(Cell<T> top){
        Cell<T> current = top.getNext();
        while (current != null){
            clearVisited(current);
            current = current.getNext();
        }
    }

    private static <T> void clearVisited(Cell<T> cell){
        cell.removeProperty(VISITED);
    }
}
