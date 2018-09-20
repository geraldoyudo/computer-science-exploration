package com.gerald.comsciexploration.junit5learning;

import com.gerald.comsciexploration.learning.Animal;
import com.gerald.comsciexploration.learning.Bird;
import com.gerald.comsciexploration.learning.Dog;
import org.junit.jupiter.api.Test;

public class MyAnimalTest {

    @Test
    public void makeBirdSound(){
        Bird bird = new Bird();
        bird.makeSound();
    }

    @Test
    public void makeDogSound(){
        Dog dog = new Dog();
        dog.makeSound();
    }

    @Test
    public void callAllSounds(){
        Animal[] animals = {new Bird(), new Dog()};
        animals[0].makeSound();
        animals[1].makeSound();
    }

    @Test
    public void callAllSoundsSometimes(){
        Animal[] animals = {new Bird(), new Dog()};
        animals[0].makeSound(10);
        animals[1].makeSound(5);
    }
}
