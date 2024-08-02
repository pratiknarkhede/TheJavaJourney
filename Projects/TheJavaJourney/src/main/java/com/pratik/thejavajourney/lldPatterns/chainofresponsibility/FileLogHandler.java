package com.pratik.thejavajourney.lldPatterns.chainofresponsibility;

//handles debug level logs
public class FileLogHandler extends LogHandler {
    public FileLogHandler(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}