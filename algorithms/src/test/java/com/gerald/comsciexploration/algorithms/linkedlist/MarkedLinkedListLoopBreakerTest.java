package com.gerald.comsciexploration.algorithms.linkedlist;

public class MarkedLinkedListLoopBreakerTest implements LinkedListLoopBreakerTest {

    @Override
    public LinkedListLoopBreaker getLoopBreaker() {
        return new MarkedAlgorithmLinkedListLoopBreaker();
    }
}
