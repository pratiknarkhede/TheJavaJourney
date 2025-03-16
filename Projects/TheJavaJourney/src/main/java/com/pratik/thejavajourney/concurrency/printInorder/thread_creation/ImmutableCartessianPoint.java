package com.pratik.thejavajourney.concurrency.printInorder.thread_creation;

public class ImmutableCartessianPoint {
    private final int x;
    private final int y;
    // silly mistake to avoid
    // if x and y is final they must have initial value
    // initializing private fields at time of declaration is one way
    // but not only one, we can initialize it via constructor also
    public ImmutableCartessianPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // no setters since fields are final and we dont want attempt to modify it


    public ImmutableCartessianPoint ImmutableCartessianPoint(int deltaX, int deltaY) {
        return new ImmutableCartessianPoint(x+deltaX,y+deltaY);
    }
}

