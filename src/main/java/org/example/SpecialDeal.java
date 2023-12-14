package org.example;

public class SpecialDeal {
    private int Id;
    private String dealType;
    private int percentage;
    private int tickets;
    private static int lastId = 0;
    public SpecialDeal(String dealType, int percentage,int tickets) {
        this.dealType = dealType;
        this.percentage = percentage;
        this.Id=++lastId;
        this.tickets=tickets;
    }

    public int getId() {
        return Id;
    }

    public String getDealType() {
        return dealType;
    }

    public int getPercentage() {
        return percentage;
    }

    public static int getLastId() {
        return lastId;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public static void setLastId(int lastId) {
        SpecialDeal.lastId = lastId;
    }
}