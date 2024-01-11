package com.example.login.Product;

public class Product {
    private String name;
//    private String detail;
    private String image;
    private double price;

    public Product(String name, String image, double price) {
        this.name = name;
//        this.detail = detail;
        this.image = image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

//    public String getDetail() {
//        return detail;
//    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }
}
