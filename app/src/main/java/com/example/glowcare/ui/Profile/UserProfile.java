package com.example.glowcare.ui.Profile;

public class UserProfile {
    private String Firstname;
    private String Lastname;
    private String Address;
    private String Email;

    public UserProfile(){

    }

    public UserProfile(String Firstname, String Lastname, String Address,String Email) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Address = Address;
        this.Email=Email;
    }

    public String getFirstname()
    {
        return Firstname;
    }

    public String getLastname()
    {
        return Lastname;
    }

    public String getAddress()
    {
        return Address;
    }
    public String getEmail()
    {
        return Email;
    }

}

