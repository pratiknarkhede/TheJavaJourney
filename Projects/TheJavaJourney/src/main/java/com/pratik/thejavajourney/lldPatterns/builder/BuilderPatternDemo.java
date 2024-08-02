package com.pratik.thejavajourney.lldPatterns.builder;

// Step 3: Client code to demonstrate the Builder pattern
public class BuilderPatternDemo {
    public static void main(String[] args) {
        // Using the builder to create a Computer object
        Computer computer = new Computer.ComputerBuilder("500 GB", "2 GB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        // Displaying the computer configuration
        System.out.println("Computer Configuration:");
        System.out.println("HDD: " + computer.getHDD());
        System.out.println("RAM: " + computer.getRAM());
        System.out.println("Graphics Card Enabled: " + computer.isGraphicsCardEnabled());
        System.out.println("Bluetooth Enabled: " + computer.isBluetoothEnabled());
    }
}
