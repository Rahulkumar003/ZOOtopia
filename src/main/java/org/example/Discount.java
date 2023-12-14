package org.example;

public class Discount {
    private int Id;
    private String discountCategory;
    private int percentage;
    private String Code;
    private static int lastId = 0;
    public Discount(String discountCategory, int percentage, String code) {
        this.discountCategory = discountCategory;
        this.percentage = percentage;
        this.Code=code;
        this.Id=++lastId;
    }
    public Discount(int Id,String discountCategory, int percentage, String code) {
        this.Id = Id;
        this.percentage = percentage;
        this.Code = Code;
        this.discountCategory=discountCategory;

    }
    public String getDiscountCategory() {
        return discountCategory;
    }

    public int getPercentage() {
        return percentage;
    }

    public int getId() {
        return Id;
    }

    public void setDiscountCategory(String discountCategory) {
        this.discountCategory = discountCategory;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountCategory='" + discountCategory + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}


