package org.example;

// BasicVisitor class implementing the Visitor interface
public class BasicVisitor extends Visitor {
    private String name;
    private double balance;

    public BasicVisitor(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

}
