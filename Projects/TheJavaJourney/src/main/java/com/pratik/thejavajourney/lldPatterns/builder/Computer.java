package com.pratik.thejavajourney.lldPatterns.builder;

// Step 1: Create the Product class
// This class represents the complex object that will be built.
public class Computer {
    private final String HDD; // Required
    private final String RAM; // Required
    private final boolean isGraphicsCardEnabled; // Optional
    private final boolean isBluetoothEnabled; // Optional

    // Private constructor to enforce the use of the Builder
    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Getters for the fields
    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    // Step 2: Create the Builder class
    // This inner static class provides the methods to build the Computer object.
    public static class ComputerBuilder {
        private final String HDD; // Required
        private final String RAM; // Required
        private boolean isGraphicsCardEnabled; // Optional
        private boolean isBluetoothEnabled; // Optional

        // Constructor for required parameters
        public ComputerBuilder(String hdd, String ram) {
            this.HDD = hdd;
            this.RAM = ram;
        }

        // Setter methods for optional parameters
        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        // Build method to create the Computer object
        public Computer build() {
            return new Computer(this);
        }
    }
}

