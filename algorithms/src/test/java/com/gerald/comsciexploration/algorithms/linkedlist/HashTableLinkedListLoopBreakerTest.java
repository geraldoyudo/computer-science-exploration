package com.gerald.comsciexploration.algorithms.linkedlist;

import com.gerald.comsciexploration.challenges.HashTableLinkedListLoopBreaker;

public class HashTableLinkedListLoopBreakerTest implements LinkedListLoopBreakerTest {

    @Override
    public LinkedListLoopBreaker getLoopBreaker() {
        return new HashTableLinkedListLoopBreaker();
    }
}
