package org.example;

public class Attraction {
    private String name;
    private String description;
    private int ticketPrice;
    private  int UniqueId; ;
    private static int lastUniqueId = 0;
    private  int Ticketcount=0;
    private int finalcount=0;
    private String Schedule="open";// 0 means close and 1 means open
    public Attraction(String name, String description) {
        this.name = name;
        this.description = description;
        UniqueId=++lastUniqueId;
    }

    public Attraction(String name, String description, int uniqueId) {
        this.name = name;
        this.description = description;
        UniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getUniqueId() {
        return UniqueId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return Schedule;
    }
    public void setSchedule(String schedule) {
        Schedule = schedule;
    }

    public  void setTicketcount(int ticketcount) {
        this.Ticketcount = ticketcount;
    }

    public  int getTicketcount() {
        return Ticketcount;
    }

    public int getFinalcount() {
        return finalcount;
    }

    public void setFinalcount(int finalcount) {
        this.finalcount = finalcount;
    }
}
