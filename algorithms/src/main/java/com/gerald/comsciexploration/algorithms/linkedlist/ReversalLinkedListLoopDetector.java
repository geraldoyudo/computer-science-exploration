package com.gerald.comsciexploration.algorithms.linkedlist;

public class ReversalLinkedListLoopDetector {

    public <T> boolean isLinkedListLooped(Cell<T> top) {
        return useLinkReversalToDetectLoop(top);
    }

    static <T> boolean useLinkReversalToDetectLoop(Cell<T> sentinel) {
       if(sentinel.getNext() == null )
           return false;
       Cell newSentinel = reverseList(sentinel);
       reverseList(newSentinel);
       if(newSentinel == sentinel){
           return true;
       }else {
           return false;
       }
    }

    private static  <T> Cell<T> reverseList(Cell<T> sentinel){
        Cell<T> previous = null;
        Cell<T> current = sentinel;
        while(current != null){
            Cell<T> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }
}
