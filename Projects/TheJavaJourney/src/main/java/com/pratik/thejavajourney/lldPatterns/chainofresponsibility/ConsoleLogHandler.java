package com.pratik.thejavajourney.lldPatterns.chainofresponsibility;

public class ConsoleLogHandler extends LogHandler {
    public ConsoleLogHandler(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}

