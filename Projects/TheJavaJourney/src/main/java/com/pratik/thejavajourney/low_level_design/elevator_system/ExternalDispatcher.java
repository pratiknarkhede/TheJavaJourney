package com.pratik.thejavajourney.low_level_design.elevator_system;// ExternalDispatcher.java
import java.util.List;

public class ExternalDispatcher {
    private List<ElevatorController> controllers; // List of elevator controllers

    public ExternalDispatcher(List<ElevatorController> controllers) {
        this.controllers = controllers;
    }

    // Submit an external request to an elevator (uses first elevator for simplicity)
    public void submitRequest(int floor, Direction direction) {
        ElevatorController controller = controllers.get(0); // Simple assignment
        controller.addExternalRequest(floor, direction);
    }
}