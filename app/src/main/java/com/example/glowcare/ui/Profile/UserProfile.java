package com.example.glowcare.ui.Profile;

import android.os.Parcel;
import android.os.Parcelable;

public class UserProfile  {
    private String id;
    private String Name;
    private String Email;
    private String imageUrl;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UserProfile() {
    }

    public UserProfile(String id, String name, String email, String imageUrl) {
        this.id = id;
        Name = name;
        Email = email;
        this.imageUrl = imageUrl;
    }
}

