package com.baraa.android_project;

/**
 * Created by BARAA on 11/26/2017.
 */

public class User {

    private String img;
    private String country_img;
    private String name;
    private String from;
    private String to;


    public  User(){

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCountry_img() {
        return country_img;
    }

    public void setCountry_img(String country_img) {
        this.country_img = country_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
