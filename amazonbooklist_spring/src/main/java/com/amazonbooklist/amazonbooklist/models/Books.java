package com.amazonbooklist.amazonbooklist.models;

public class Books {
    private String title;
    private String author;
    private Double price;
    private String url;
    private String imageUrl;

    public Books(String title, String author, Double price, String url, String imageUrl) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
