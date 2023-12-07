package com.example.myapplication;

public class SpaceImageData {
    private long id;
    private String title;
    private String date;
    private String imageUrl;
    private String description;

    public SpaceImageData(long id, String title, String date, String imageUrl, String description) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    // Getters and setters for each field
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
