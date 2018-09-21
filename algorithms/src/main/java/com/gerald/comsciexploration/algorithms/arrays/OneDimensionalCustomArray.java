package com.gerald.comsciexploration.algorithms.arrays;

public class OneDimensionalCustomArray <T>{
    private int lowerBound = 0;
    private T[] array;

    public OneDimensionalCustomArray(int lowerBound, T[] array) {
        this.lowerBound = lowerBound;
        this.array = array;
    }

    public OneDimensionalCustomArray(T[] array) {
        this.array = array;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public T get(int index){
        int normalizedIndex = index - lowerBound;
        return this.array[normalizedIndex];
    }
}
