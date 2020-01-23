package com.example.myapplication.model;

public class LoginRequestBody {
    private String accessToken;
    private String platform;
    private String customerPassword;
    private String customerEmail;
    private String idToken;

    public LoginRequestBody(String accessToken, String platform, String userName,String password,String idToken) {
        this.accessToken = accessToken;
        this.platform = platform;
        this.customerPassword = password;
        this.customerEmail = userName;
        this.idToken = idToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}
