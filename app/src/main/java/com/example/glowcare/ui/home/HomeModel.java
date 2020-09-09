package com.example.glowcare.ui.home;

/**
 *model file for Home
 */
public class HomeModel {
    private String id;
    private String name;
    private double price;
    private String imageurl;

    /**
     * setter for price parameter
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * getter for id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * setter for id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getter for image
     * @return
     */
    public  String getImageurl() {
        return imageurl;
    }

    /**
     * setter for image
     * @param imageurl
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /**
     * constructor with no parameters
     */
    public HomeModel() {
    }

    /**
     * getter for name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for price
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Constructor with id , name, price, imageurl as parameters
     * @param id
     * @param name
     * @param price
     * @param imageurl
     */
    public HomeModel(String id, String name, double price, String imageurl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageurl = imageurl;

    }


}
