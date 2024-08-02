package com.pratik.thejavajourney.lldPatterns.decorator;

public class PizzaShop {
    public static void main(String[] args) {
        Pizzaa pizzaa=new BasicPizaa();
        System.out.println("Basic Pizza"+pizzaa.getDescription()+" "+pizzaa.getCost());

        pizzaa=new CheeseDecorator(pizzaa);
        System.out.println("Cheese Pizza"+pizzaa.getDescription()+" "+pizzaa.getCost());

        pizzaa=new PepporiniDecorator(pizzaa);
        System.out.println("Pepporini toppings"+pizzaa.getDescription()+" "+pizzaa.getCost());
    }
}
