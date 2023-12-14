package org.example;

public  class Membership {
    private String type;
    private int price;

    public Membership(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return type + " (₹" + price + ")";
    }
}