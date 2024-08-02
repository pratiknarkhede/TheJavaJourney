package com.pratik.thejavajourney.lldPatterns.decorator;

public class PepporiniDecorator extends ToppingsDecorator{
    public PepporiniDecorator(Pizzaa pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+" with pepporini toppings";
    }

    @Override
    public Double getCost() {
        return pizza.getCost()+30.0;
    }
}
