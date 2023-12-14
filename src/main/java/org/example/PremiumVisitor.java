package org.example;

// PremiumVisitor class implementing the Visitor interface
public class PremiumVisitor extends Visitor {
    private String name;
    private double balance;

    public PremiumVisitor(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }


}
