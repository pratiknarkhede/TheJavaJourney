package com.pratik.thejavajourney.low_level_design.elevator_system;

// ElevatorDisplay.java
public class ElevatorDisplay {
    private int currentFloor;
    private Direction direction;

    // Update and show the display
    public void setDisplay(int floor, Direction direction) {
        this.currentFloor = floor;
        this.direction = direction;
        System.out.println("Display: Floor " + floor + ", Direction: " + direction);
    }
}