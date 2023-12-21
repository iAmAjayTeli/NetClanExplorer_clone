package com.example.assigment.Models;

import android.widget.TextView;

public class ExploreModel {
    int img;
    String name,adress, hobby1, hobby2, hobby3, availability;

    public ExploreModel(int img, String name, String adress, String hobby1, String hobby2, String hobby3, String availability) {
        this.img = img;
        this.name = name;
        this.adress = adress;
        this.hobby1 = hobby1;
        this.hobby2 = hobby2;
        this.hobby3 = hobby3;
        this.availability = availability;
    }



    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getHobby1() {
        return hobby1;
    }

    public void setHobby1(String hobby1) {
        this.hobby1 = hobby1;
    }

    public String getHobby2() {
        return hobby2;
    }

    public void setHobby2(String hobby2) {
        this.hobby2 = hobby2;
    }

    public String getHobby3() {
        return hobby3;
    }

    public void setHobby3(String hobby3) {
        this.hobby3 = hobby3;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
