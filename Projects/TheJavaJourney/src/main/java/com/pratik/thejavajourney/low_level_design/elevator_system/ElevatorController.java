package com.pratik.thejavajourney.low_level_design.elevator_system;// ElevatorController.java
import java.util.HashSet;
import java.util.Set;

public class ElevatorController {
    private ElevatorCar elevator;      // The elevator it controls
    private Set<Integer> upStops;      // Floors requesting up
    private Set<Integer> downStops;    // Floors requesting down
    private Set<Integer> internalStops; // Internal destination requests

    public ElevatorController(ElevatorCar elevator) {
        this.elevator = elevator;
        this.upStops = new HashSet<>();
        this.downStops = new HashSet<>();
        this.internalStops = new HashSet<>();
    }

    // Add an external request from a floor
    public void addExternalRequest(int floor, Direction direction) {
        if (direction == Direction.UP) {
            upStops.add(floor);
        } else if (direction == Direction.DOWN) {
            downStops.add(floor);
        }
        processRequests();
    }

    // Add an internal request from inside the elevator
    public void addInternalRequest(int floor) {
        internalStops.add(floor);
        processRequests();
    }

    // Process all pending requests (simplified logic)
    private void processRequests() {
        if (!internalStops.isEmpty()) {
            int nextFloor = internalStops.iterator().next();
            elevator.moveToFloor(nextFloor);
            internalStops.remove(nextFloor);
        }
        // Future enhancement: Handle upStops and downStops
    }
}