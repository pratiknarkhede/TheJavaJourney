package com.pratik.thejavajourney.lldPatterns.facade;

// DVD Player class
public class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is ON");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        System.out.println("Stopping the DVD Player");
    }

    public void off() {
        System.out.println("DVD Player is OFF");
    }
}