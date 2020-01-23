package com.example.myapplication.model;


public class Signupbody {

    private  String customerEmailId;
    private String customerPassword;
    private  String customerName;
    private String profilePicture;
    private  String locale;
    private boolean isLoggedIn;

    public Signupbody(String customerEmailId, String customerPassword, String customerName, String profilePicture, String locale) {
        //this.customerId = customerId;
        this.customerEmailId = customerEmailId;
        this.customerPassword = customerPassword;
        this.customerName = customerName;
        this.profilePicture = profilePicture;
        this.locale = locale;
      //  this.isLoggedIn = isLoggedIn;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
