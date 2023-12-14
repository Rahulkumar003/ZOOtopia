package org.example;

public  class Visitor implements User {
    private String name;
    private int age;
    private String phoneNumber;
    private int balance;
    private String email;
    private String password;
    private Membership membership;
    public Visitor(String name, int age, String phoneNumber, int balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
    }
    public Visitor(){

    }
    public Visitor(String name, int age, String phoneNumber, int balance, String email, String password, Membership membership) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.membership = membership;
    }
    public void buyMembership(String membershipType,Visitor ivisitor) {
        if (membershipType.equals("Basic")) {
            if (balance >= 20) {
                balance -= 20;  // Deduct the cost of membership
                ivisitor.setMembership(membership);
                System.out.println("Basic Membership purchased successfully.");
            } else {
                System.out.println("Insufficient balance to purchase Basic Membership.");
            }
        } else if (membershipType.equals("Premium")) {
            if (balance >= 50) {
                balance -= 50;  // Deduct the cost of membership
                ivisitor.setMembership(membership);
                System.out.println("Premium Membership purchased successfully.");
            } else {
                System.out.println("Insufficient balance to purchase Premium Membership.");
            }
        } else {
            System.out.println("Invalid membership type.");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Membership getMembership() {
        return membership;
    }

    @Override
    public void register() {

    }

    @Override
    public void login() {

    }

    public void login(String mail, String passwordVis) {
    }
}
