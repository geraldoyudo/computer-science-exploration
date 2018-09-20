package com.gerald.comsciexploration.algorithms.linkedlist;

public class TracingLinkedListLoopBreaker implements LinkedListLoopBreaker {

    @Override
    public <T> Cell<T> breakLoopPoint(Cell<T> top) {
        return useLinkTracingToBreakLoop(top);
    }

    static <T> Cell<T> useLinkTracingToBreakLoop(Cell<T> sentinel) {
        Cell<T> cell = sentinel;
        while(cell.getNext() != null){
            Cell<T> tracer = sentinel;
            while (tracer != cell){
                if(tracer.getNext() == cell.getNext()){
                    Cell<T> loopPoint = cell.getNext();
                    cell.setNext(null);
                    return loopPoint;
                }
                tracer = tracer.getNext();
            }
            cell = cell.getNext();
        }
        return null;
    }
}
