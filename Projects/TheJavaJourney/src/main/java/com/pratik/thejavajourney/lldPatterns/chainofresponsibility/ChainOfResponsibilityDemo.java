package com.pratik.thejavajourney.lldPatterns.chainofresponsibility;

public class ChainOfResponsibilityDemo {
    private static LogHandler getChainOfLoggers() {
        LogHandler errorLogger = new ErrorLogHandler(LogLevel.ERROR);
        LogHandler fileLogger = new FileLogHandler(LogLevel.DEBUG);
        LogHandler consoleLogger = new ConsoleLogHandler(LogLevel.INFO);

        errorLogger.setNextHandler(fileLogger);
        fileLogger.setNextHandler(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        LogHandler loggerChain = getChainOfLoggers();

        loggerChain.logMessage(LogLevel.INFO, "This is an information.");
        System.out.println("---------");
        loggerChain.logMessage(LogLevel.DEBUG, "This is a debug level information.");
        System.out.println("---------");
        loggerChain.logMessage(LogLevel.ERROR, "This is an error information.");
    }
}
