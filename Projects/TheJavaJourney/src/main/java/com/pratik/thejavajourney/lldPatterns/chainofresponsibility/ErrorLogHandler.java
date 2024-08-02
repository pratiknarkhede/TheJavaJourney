package com.pratik.thejavajourney.lldPatterns.chainofresponsibility;

public class ErrorLogHandler extends LogHandler {
    public ErrorLogHandler(int level) {
        this.level = level;
    }
    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}