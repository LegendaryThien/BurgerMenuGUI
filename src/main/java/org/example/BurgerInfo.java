package org.example;


//This class represents the information about a single burger.

public class BurgerInfo {
    public String name;
    public double price;
    public String topping;
    public BurgerInfo(String name, double price, String topping) {
        this.name = name;
        this.price = price;
        this.topping = topping;
    }

    // Getters and setters for the properties
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getTopping() {
        return topping;
    }
    public void setTopping(String topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "BurgerInfo{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", topping='" + topping + '\'' +
                '}';
    }
}

