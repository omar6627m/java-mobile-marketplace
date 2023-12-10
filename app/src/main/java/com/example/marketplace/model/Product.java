package com.example.marketplace.model;

public class Product {
    private String name;

    private String imageUrl;
    private Double price;

    public Product(String name, String imageUrl, Double price) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
