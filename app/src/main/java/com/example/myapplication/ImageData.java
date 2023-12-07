package com.example.myapplication;

import java.io.Serializable;

public class ImageData implements Serializable {
    private String date;
    private String title;
    private String imageUrl;

    public ImageData(String date, String title, String imageUrl) {
        this.date = date;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
