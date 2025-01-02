package com.amazonbooklist.amazonbooklist.models;

public class Books {
    private String title;
    private String author;
    private String publisher;
    private String language;
    private Long isbn;
    private Double price;
    private String url;
    private String imageUrl;

    public Books(String title, String author, String publisher, String language, Long isbn, Double price, String url, String imageUrl) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.language = language;
        this.isbn = isbn;
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

    public String getPublisher() {
        return publisher;
    }

    public String getLanguage() {
        return language;
    }

    public Long getIsbn() {
        return isbn;
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
