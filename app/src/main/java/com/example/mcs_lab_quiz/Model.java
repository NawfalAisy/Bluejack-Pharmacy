package com.example.mcs_lab_quiz;

public class Model {

    int image;
    String name;
    String manufakture;
    String price;

    public Model(int image, String name, String manufakture, String price, String detail) {
        this.image = image;
        this.name = name;
        this.manufakture = manufakture;
        this.price = price;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    String detail;
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufakture() {
        return manufakture;
    }

    public void setManufakture(String manufakture) {
        this.manufakture = manufakture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
