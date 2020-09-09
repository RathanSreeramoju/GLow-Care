package com.example.glowcare.ui.cart;

/**
 * To give the card details.
 */
public class CartModel {
    private String id;
    private String name;
    private double price;
    private String imageurl;

    /**
     * to get the Id.
     * @return :Returns the Id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     * @param id :Sets the current Id value.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the imageId.
     * @return :Returns the image Id.
     */
    public  String getImageurl() {
        return imageurl;
    }

    /**
     * sets the image into the card.
     * @param imageurl :Sets the current image.
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /**
     * constructor with no parameters.
     */
    public CartModel() {
    }

    /**
     * gets the name.
     * @return :returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name.
     * @param name : Sets the current name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price.
     * @return :returns the price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price.
     * @param price :Sets the current price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * constructor with all parameters
     * @param id :item id.
     * @param name : item name.
     * @param price :item price.
     * @param imageurl :item image.
     */
    public CartModel(String id, String name, double price, String imageurl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageurl = imageurl;
    }


}
