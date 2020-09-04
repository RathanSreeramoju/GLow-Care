package com.example.glowcare.ui.home;

<<<<<<< HEAD
import java.net.URI;

public class HomeModel {

    private String name;
    private long price;
    private String imageurl;

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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public HomeModel(String name, long price,String imageurl) {
        this.name = name;
        this.price = price;
        this.imageurl = imageurl;
    }
=======
class HomeModel {
    package com.example.glowcare.ui.home;

import java.net.URI;

    public class HomeModel {

        private String name;
        private long price;
        private String imageurl;

        public String getImageurl() {
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

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }

        public HomeModel(String name, long price,String imageurl) {
            this.name = name;
            this.price = price;
            this.imageurl = imageurl;
        }
    }

>>>>>>> cf72d5328f84b1a20ab1a8c489c40cc334f803a6
}
