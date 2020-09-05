package com.example.glowcare.ui.cart;

public class CartModel {
    private String name;
    private double price;
    private String imageurl;

    public  String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public CartModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public CartModel(String name, double price,String imageurl) {
        this.name = name;
        this.price = price;
        this.imageurl = imageurl;
    }


}
