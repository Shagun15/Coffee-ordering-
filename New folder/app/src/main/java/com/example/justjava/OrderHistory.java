package com.example.justjava;

public class OrderHistory {



    String drinkName;



    float drinkPrice;
    String topping1Name;
    float topping1Price;
    String topping2Name;
    float topping2Price;

    public OrderHistory(){

    }

    public OrderHistory(String drinkName, float drinkPrice, String topping1Name, float topping1Price, String topping2Name, float topping2Price) {
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
        this.topping1Name = topping1Name;
        this.topping1Price = topping1Price;
        this.topping2Name = topping2Name;
        this.topping2Price = topping2Price;
    }

    public String getName() {
        return drinkName;
    }

    public void setName(String drinkName) {
        this.drinkName = drinkName;
    }



    public float getPrice() {
        return drinkPrice;
    }

    public void setPrice(float drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public String getTopping1Name() {
        return topping1Name;
    }

    public void setTopping1Name(String topping1Name) {
        this.topping1Name = topping1Name;
    }

    public float getTopping1Price() {
        return topping1Price;
    }

    public void setTopping1Price(float topping1Price) {
        this.topping1Price = topping1Price;
    }

    public String getTopping2Name() {
        return topping2Name;
    }

    public void setTopping2Name(String topping2Name) {
        this.topping2Name = topping2Name;
    }

    public float getTopping2Price() {
        return topping2Price;
    }

    public void setTopping2Price(float topping2Price) {
        this.topping2Price = topping2Price;
    }




}
