package com.pratik.thejavajourney.low_level_design.elevator_system;

// Main.java
public class Main {
    public static void main(String[] args) {
        // Create a building with 10 floors and 2 elevators
        Building building = new Building(10, 2);

        // Simulate pressing up button on floor 3
        Floor floor3 = building.getFloor(3);
        floor3.pressUpButton(building.getDispatcher());

        // Simulate pressing internal button for floor 7 in elevator 0
        ElevatorCar elevator0 = building.getElevator(0);
        elevator0.getInternalButtons().pressButton(7);
    }
}