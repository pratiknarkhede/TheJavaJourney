package com.pratik.thejavajourney.low_level_design.elevator_system;

// InternalButtons.java
public class InternalButtons {
    private ElevatorController controller;

    public InternalButtons(ElevatorController controller) {
        this.controller = controller;
    }

    // Press a button for a destination floor
    public void pressButton(int floor) {
        System.out.println("Internal button pressed for floor " + floor);
        controller.addInternalRequest(floor);
    }
}