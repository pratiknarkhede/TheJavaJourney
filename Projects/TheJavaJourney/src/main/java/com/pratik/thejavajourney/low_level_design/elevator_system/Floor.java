package com.pratik.thejavajourney.low_level_design.elevator_system;

public class Floor {
    private int floorNumber;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    // Press the up button, notifying the dispatcher
    public void pressUpButton(ExternalDispatcher dispatcher){
        System.out.println("Up button pressed on floor " + floorNumber);
        dispatcher.submitRequest(floorNumber, Direction.UP);
    }

    // Press the down button, notifying the dispatcher
    public void pressDownButton(ExternalDispatcher dispatcher) {
        System.out.println("Down button pressed on floor " + floorNumber);
        dispatcher.submitRequest(floorNumber, Direction.DOWN);
    }
}
