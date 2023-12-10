package com.example.marketplace.model;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private String name;
    private String imageUrl;
    private List<Product> productList;

    public Marketplace(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.productList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
