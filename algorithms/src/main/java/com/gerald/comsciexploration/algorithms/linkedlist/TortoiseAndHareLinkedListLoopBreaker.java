package com.gerald.comsciexploration.algorithms.linkedlist;

public class TortoiseAndHareLinkedListLoopBreaker implements LinkedListLoopBreaker {

    @Override
    public <T> Cell<T> breakLoopPoint(Cell<T> top) {
        return useTortoiseAndHareToBreakLoop(top);
    }

    static <T> Cell<T> useTortoiseAndHareToBreakLoop(Cell<T> sentinel) {
        Cell<T> tortoise = sentinel.getNext();
        Cell<T> hare = sentinel.getNext();
        boolean hareIsTired = false;
        boolean tortoiseAndHareMetAgain = false;
        boolean tortoiseAndHareMetFirst = false;
        while (hare != null){
            tortoise = tortoise.getNext();
            if(tortoiseAndHareMetAgain){
                // make hare stationary
            }else if(hareIsTired) {
                hare = hare.getNext();
            }
            else{
                hare = hare.getNext();
                if(hare == null) return null;
                hare = hare.getNext();
            }

            if(hare == tortoise){
                if(tortoiseAndHareMetFirst){
                    tortoiseAndHareMetAgain = true;
                }else {
                    tortoiseAndHareMetFirst = true;
                }
                if(tortoiseAndHareMetFirst && !tortoiseAndHareMetAgain) {
                    hare = sentinel.getNext();
                    hareIsTired = true;
                }
            }

            if(tortoiseAndHareMetAgain && (tortoise.getNext() == hare)){
                tortoise.setNext(null);
                return hare;
            }
        }
        return null;
    }
}
