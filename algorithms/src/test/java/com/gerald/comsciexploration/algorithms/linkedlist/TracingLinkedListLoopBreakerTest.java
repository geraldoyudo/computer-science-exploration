package com.gerald.comsciexploration.algorithms.linkedlist;

public class TracingLinkedListLoopBreakerTest implements LinkedListLoopBreakerTest {

    @Override
    public LinkedListLoopBreaker getLoopBreaker() {
        return new TracingLinkedListLoopBreaker();
    }
}
