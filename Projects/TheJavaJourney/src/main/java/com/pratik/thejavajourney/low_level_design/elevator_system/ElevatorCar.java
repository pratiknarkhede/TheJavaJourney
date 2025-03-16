package com.pratik.thejavajourney.low_level_design.elevator_system;

public class ElevatorCar {
    private int currentFloor;         // Current floor of the elevator
    private Direction direction;      // Current direction of movement
    private ElevatorController controller; // Manages elevator logic
    private ElevatorDoor door;        // Door component
    private ElevatorDisplay display;  // Display component
    private InternalButtons internalButtons; // Internal buttons component

    public ElevatorCar(int id) {
        this.currentFloor = 0; // Start at ground floor
        this.direction = Direction.IDLE;
        this.controller = new ElevatorController(this);
        this.door = new ElevatorDoor();
        this.display = new ElevatorDisplay();
        this.internalButtons = new InternalButtons(controller);
    }

    // Move elevator to a specified floor
    public void moveToFloor(int floor) {
        System.out.println("Elevator moving to floor " + floor);
        this.currentFloor = floor;
        display.setDisplay(currentFloor, direction);
        door.open();
        door.close();
    }

    public void openDoor() { door.open(); }
    public void closeDoor() { door.close(); }
    public int getCurrentFloor() { return currentFloor; }
    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }
    public ElevatorController getController() { return controller; }
    public InternalButtons getInternalButtons() { return internalButtons; }




}
