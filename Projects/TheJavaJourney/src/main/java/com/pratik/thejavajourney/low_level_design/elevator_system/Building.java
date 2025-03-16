package com.pratik.thejavajourney.low_level_design.elevator_system;// Building.java
import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Floor> floors;           // All floors in the building
    private List<ElevatorCar> elevators;  // All elevators in the building
    private ExternalDispatcher dispatcher;

    public Building(int numFloors, int numElevators) {
        // Initialize floors
        floors = new ArrayList<>();
        for (int i = 0; i < numFloors; i++) {
            floors.add(new Floor(i));
        }
        // Initialize elevators and their controllers
        elevators = new ArrayList<>();
        List<ElevatorController> controllers = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            ElevatorCar elevator = ElevatorCreator.createElevator(i);
            elevators.add(elevator);
            controllers.add(elevator.getController());
        }
        dispatcher = new ExternalDispatcher(controllers);
    }

    public Floor getFloor(int floorNumber) { return floors.get(floorNumber); }
    public ElevatorCar getElevator(int elevatorId) { return elevators.get(elevatorId); }
    public ExternalDispatcher getDispatcher() { return dispatcher; }
}