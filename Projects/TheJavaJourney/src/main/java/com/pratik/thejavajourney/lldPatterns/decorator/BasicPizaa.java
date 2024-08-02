package com.pratik.thejavajourney.lldPatterns.decorator;

public class BasicPizaa implements Pizzaa{
    @Override
    public String getDescription() {
        return "basic margarita pizza";
    }

    @Override
    public Double getCost() {
        return 150.0;
    }
}
