package com.example.glowcare.ui.Profile;

public class UserProfile {
    private String id;
    private String Name;
    private String Email;
    private String imageUrl;

    public UserProfile(){

    }

    public UserProfile(String id, String name, String email, String imageUrl)
    {
        this.id = id;
        Name = name;
        Email = email;
        this.imageUrl = imageUrl;
    }

    /**
     * retrieve id value
     * @return string data type
     */
    public String getId() {
        return id;
    }

    /**
     * set id value
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * retreive value of name
     * @return string data type
     */
    public String getName() {
        return Name;
    }
    /**
     * set value of name
     * @param
     */
    public void setName(String name) {
        Name = name;
    }
    /**
     * retreive value of email
     * @return string data type
     */
    public String getEmail() {
        return Email;
    }
    /**
     * set value of email
     * @param
     */

    public void setEmail(String email) {
        Email = email;
    }
    /**
     * retreive image
     * @return string data type
     */

    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * set image
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}

