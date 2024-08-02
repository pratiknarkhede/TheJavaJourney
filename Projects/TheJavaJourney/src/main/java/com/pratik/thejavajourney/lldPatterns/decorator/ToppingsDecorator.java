package com.pratik.thejavajourney.lldPatterns.decorator;

public abstract class ToppingsDecorator extends BasicPizaa implements Pizzaa{
    Pizzaa pizza;

    public ToppingsDecorator(Pizzaa pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public Double getCost() {
        return pizza.getCost();
    }
}
