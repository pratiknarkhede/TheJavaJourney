package com.pratik.thejavajourney.lldPatterns.chainofresponsibility;

public abstract class LogHandler {
    protected LogHandler nextHandler;
    protected int level;

    public void setNextHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
            return; // Stop here after handling the message
        }
        if (nextHandler != null) {
            nextHandler.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}