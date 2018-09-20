package com.gerald.comsciexploration.algorithms.arrays;


import java.util.Arrays;
import java.util.Optional;

public class NDimensionArray<T> {

    private int[] bounds;
    private T defaultEntry;
    private int dimensionLength;
    private int[] sizes;
    private T[] array;

    private NDimensionArray(int[] bounds, T... defaultEntryArray) {
        if (isOddLength(bounds)) {
            throw new IllegalArgumentException(
                    "Bounds array must have even length " + "(upper and lower bounds for each dimension)");
        }
        this.bounds = bounds;
        this.defaultEntry = defaultEntryArray[0];
        this.dimensionLength = this.bounds.length / 2;
        initializeArray(bounds, defaultEntryArray);
    }

    private boolean isOddLength(int[] bounds) {
        return ((bounds.length) % 2 == 1);
    }

    private void initializeArray(int[] bounds, T[] defaultEntryArray) {
        int sliceSize = 1;
        sizes = new int[dimensionLength];
        for(int i = dimensionLength -1; i >= 0; --i){
            sizes[i] = sliceSize;
            sliceSize = sliceSize * (bounds[2*i + 1] - bounds[2*i] + 1);
        }
        array = Arrays.copyOf(defaultEntryArray, sliceSize);
    }

    public T get(int... dimensions) {
        int index = mapDimensionsToIndex(dimensions);
        return Optional.ofNullable(array[index]).orElse(defaultEntry);
    }

    public void set(T object, int... dimensions) {
        int index = mapDimensionsToIndex(dimensions);
        array[index] = object;
    }

    private int mapDimensionsToIndex(int[] dimensions){
        checkBoundary(bounds, dimensions);
        int index = 0;
        for(int i=0; i < dimensionLength; ++i){
            index = index + (dimensions[i] - bounds[2*i]) * sizes [i];
        }
        return index;
    }

    private void checkBoundary(int[] bounds, int[] dimensions){
        if(dimensions.length != dimensionLength)
            throw new IllegalArgumentException("Enter the correct number of dimensions which is " + dimensionLength);
        for(int i=0; i< dimensions.length; ++i){
            if(dimensions[i] < bounds [2*i] || dimensions[i] > bounds [2*i + 1]){
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {

        private int[] bounds;
        private T defaultValue;

        public Builder<T> bounds(int... bounds) {
            this.bounds = bounds;
            return this;
        }

        public Builder<T> defaultValue(T defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public NDimensionArray<T> build() {
            return new NDimensionArray<>(bounds, defaultValue);
        }
    }
}
