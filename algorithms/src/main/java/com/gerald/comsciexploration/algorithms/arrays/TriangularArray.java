package com.gerald.comsciexploration.algorithms.arrays;

import java.util.Arrays;

public class TriangularArray<T> {
    public enum MirrorEntryHandlingStrategy {
        THROW_EXCEPTION,
        RETURN_MIRROR_VALUE,
        RETURN_DEFAULT_VALUE;
    }

    private int rowSize;
    private int size;
    private T[] array;
    private MirrorEntryHandlingStrategy mirrorEntryHandlingStrategy;
    private T defaultValue;

    private TriangularArray(int rowSize, MirrorEntryHandlingStrategy strategy, T... defaultEntries) {
        this.rowSize = rowSize;
        this.size = ((rowSize * rowSize) + rowSize) / 2;
        array = Arrays.copyOf(defaultEntries, size);
        this.mirrorEntryHandlingStrategy = strategy;
        this.defaultValue = defaultEntries[0];
    }

    public T get(int rowIndex, int columnIndex) {
        checkBoundaries(rowIndex, columnIndex);
        if( columnIndex > rowIndex ){
            return getMirrorEntry(rowIndex, columnIndex);
        }
        int index = mapIndicesToIndex(rowIndex, columnIndex);
        return array[index];
    }

    private void checkBoundaries(int rowIndex, int columnIndex){
        if(rowIndex >= rowSize || rowIndex < 0
                || columnIndex >= rowSize || columnIndex < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private int mapIndicesToIndex(int rowIndex, int columnIndex) {
        int rowIndexMinusOne = rowIndex - 1;
        return (((rowIndexMinusOne * rowIndexMinusOne) + rowIndexMinusOne) / 2) + columnIndex;
    }

    private T getMirrorEntry(int rowIndex, int columnIndex){
        switch (mirrorEntryHandlingStrategy){
            case RETURN_DEFAULT_VALUE:
                return this.defaultValue;
            case RETURN_MIRROR_VALUE:
                return get(columnIndex, rowIndex);
            default:
                throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(T value, int rowIndex, int columnIndex) {
        checkBoundaries(rowIndex, columnIndex);
        if( columnIndex > rowIndex ){
            setMirrorEntry(value, rowIndex, columnIndex);
            return;
        }
        int index = mapIndicesToIndex(rowIndex, columnIndex);
        array[index] = value;
    }

    private void setMirrorEntry(T value, int rowIndex, int columnIndex){
        switch (mirrorEntryHandlingStrategy){
            case RETURN_DEFAULT_VALUE:
                return;
            case RETURN_MIRROR_VALUE:
                set(value, columnIndex, rowIndex);
                return;
            default:
                throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size() {
        return size;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private int rowSize;
        private T defaultValue;
        private MirrorEntryHandlingStrategy mirrorEntryHandlingStrategy;

        public Builder<T> rowSize(int rowSize){
            this.rowSize = rowSize;
            return this;
        }

        public Builder<T> defaultValue(T defaultValue){
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder<T> handleMirrorEntries(MirrorEntryHandlingStrategy strategy){
            this.mirrorEntryHandlingStrategy = strategy;
            return this;
        }

        public TriangularArray<T> build(){
            return new TriangularArray<>(rowSize,
                    mirrorEntryHandlingStrategy, defaultValue);
        }
    }
}
