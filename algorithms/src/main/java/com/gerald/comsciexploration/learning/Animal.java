package com.gerald.comsciexploration.learning;

public abstract class Animal {
    public abstract void makeSound();

    public void makeSound(int numberOfTimes) {
        for(int i=0; i < numberOfTimes; ++i ){
            makeSound();
        }
    }
}
