package com.pratik.thejavajourney.lldPatterns.decorator;

public class CheeseDecorator extends ToppingsDecorator{
    public CheeseDecorator(Pizzaa pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+",with extra cheese";
    }

    @Override
    public Double getCost() {
        return pizza.getCost()+30.0;
    }
}
