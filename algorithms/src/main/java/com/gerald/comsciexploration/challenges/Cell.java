package com.gerald.comsciexploration.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Cell <T>{
    private Map<String, Object> meta = new HashMap<>();

    private T value;
    private Cell<T> next;

    public Cell(T value) {
        this.value = value;
        this.next = null;
    }

    public Cell(T value, Cell<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Cell<T> getNext() {
        return next;
    }

    public void setNext(Cell<T> next) {
        this.next = next;
    }

    public void setProperty(String property, Object value){
        this.meta.put(property, value);
    }

    public Optional getProperty(String property){
        return Optional.ofNullable(meta.get(property));
    }

    public void removeProperty(String property){
        this.meta.remove(property);
    }
}
