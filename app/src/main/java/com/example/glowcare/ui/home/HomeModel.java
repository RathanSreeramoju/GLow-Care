package com.example.glowcare.ui.home;


import java.net.URI;

public class HomeModel {
    private String id;
    private String name;
    private double price;
    private String imageurl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public  String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public HomeModel() {
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

    public HomeModel(String id,String name, double price,String imageurl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageurl = imageurl;
    }


}
