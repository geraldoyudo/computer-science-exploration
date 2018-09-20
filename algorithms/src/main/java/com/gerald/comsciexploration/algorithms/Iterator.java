package com.gerald.comsciexploration.algorithms;

public interface Iterator<T> {

    void first();

    T current();

    void next();

    void previous();

    void last();

    boolean done();
}
