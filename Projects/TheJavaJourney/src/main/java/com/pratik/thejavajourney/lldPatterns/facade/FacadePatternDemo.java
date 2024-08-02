package com.pratik.thejavajourney.lldPatterns.facade;

public class FacadePatternDemo {
    public static void main(String[] args) {
        // Create subsystem components
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        Lights lights = new Lights();

        // Create the facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, soundSystem, lights);

        // Use the facade to watch a movie
        homeTheater.watchMovie("Inception");

        // End the movie
        homeTheater.endMovie();
    }
}