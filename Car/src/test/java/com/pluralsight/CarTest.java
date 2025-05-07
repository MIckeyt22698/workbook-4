package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    void accelerate() {
//arrange
        Car car = new Car("yamaha", "R6");
        int spedChange = 15;
        int expectedSpeed = 15;

//act
        car.accelerate(spedChange);

//assert
        assertEquals(expectedSpeed, car.getSpeed());

    }
}
