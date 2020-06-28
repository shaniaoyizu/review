package com.sunbc.beans.spel;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Car {
    private String brand;
    private double price;
    private double typePerimeter;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTypePerimeter() {
        return typePerimeter;
    }

    public void setTypePerimeter(double typePerimeter) {
        this.typePerimeter = typePerimeter;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", typePerimeter=" + typePerimeter +
                '}';
    }
}
