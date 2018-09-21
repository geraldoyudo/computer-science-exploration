package com.gerald.comsciexploration.algorithms;

public class StepIterator<T> implements Iterator<T> {

    private T[] elements;
    private int index = -1;
    private int stepSize;

    public StepIterator(int stepSize, T... elements) {
        this.elements = elements;
        this.stepSize = stepSize;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public T current() {
        ensureAccessibleIndex();
        return elements[index];
    }

    private void ensureAccessibleIndex() {
        if (index < 0 || index >= elements.length) {
            throw new IllegalStateException("Index out of bounds");
        }
    }

    @Override
    public void next() {
        index += stepSize;
    }

    @Override
    public void previous() {
        index -= stepSize;
    }

    @Override
    public void last() {
        index = elements.length - 1;
    }

    @Override
    public boolean done() {
        return index >= elements.length;
    }
}
