package com.pratik.thejavajourney.lldPatterns.facade;

// Projector class
public class Projector {
    public void on() {
        System.out.println("Projector is ON");
    }

    public void setInput(String input) {
        System.out.println("Projector input set to: " + input);
    }

    public void off() {
        System.out.println("Projector is OFF");
    }
}