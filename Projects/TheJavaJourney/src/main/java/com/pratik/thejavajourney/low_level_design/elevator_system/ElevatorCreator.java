package com.pratik.thejavajourney.low_level_design.elevator_system;

// ElevatorCreator.java
public class ElevatorCreator {
    // Factory method to create an elevator
    public static ElevatorCar createElevator(int id) {
        return new ElevatorCar(id);
    }
}