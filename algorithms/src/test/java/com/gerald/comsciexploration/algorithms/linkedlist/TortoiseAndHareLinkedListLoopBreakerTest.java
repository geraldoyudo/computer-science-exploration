package com.gerald.comsciexploration.algorithms.linkedlist;

public class TortoiseAndHareLinkedListLoopBreakerTest implements LinkedListLoopBreakerTest {

    @Override
    public LinkedListLoopBreaker getLoopBreaker() {
        return new TortoiseAndHareLinkedListLoopBreaker();
    }
}
