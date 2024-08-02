package com.pratik.thejavajourney.lldPatterns.facade;

// Lights class
public class Lights {
    public void dim(int level) {
        System.out.println("Dimming lights to: " + level + "%");
    }

    public void on() {
        System.out.println("Lights are ON");
    }

    public void off() {
        System.out.println("Lights are OFF");
    }
}