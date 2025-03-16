package com.pratik.thejavajourney.low_level_design.elevator_system;

// ElevatorDoor.java
public class ElevatorDoor {
    private boolean isOpen;

    public ElevatorDoor() {
        this.isOpen = false;
    }

    public void open() {
        System.out.println("Door opening");
        isOpen = true;
    }

    public void close() {
        System.out.println("Door closing");
        isOpen = false;
    }
}