package com.pratik.thejavajourney.lldPatterns.facade;

public class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;
    private Lights lights;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, SoundSystem soundSystem, Lights lights) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim(10); // Dim the lights
        projector.on(); // Turn on the projector
        projector.setInput("DVD"); // Set projector input to DVD
        soundSystem.on(); // Turn on the sound system
        soundSystem.setVolume(5); // Set volume
        dvdPlayer.on(); // Turn on the DVD player
        dvdPlayer.play(movie); // Play the movie
    }
    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        dvdPlayer.stop(); // Stop the DVD player
        dvdPlayer.off(); // Turn off the DVD player
        soundSystem.off(); // Turn off the sound system
        projector.off(); // Turn off the projector
        lights.on(); // Turn on the lights
    }
}