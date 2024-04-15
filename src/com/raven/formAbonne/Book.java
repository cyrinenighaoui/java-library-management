package com.raven.formAbonne;

public class Book {
    String title;
    String author;
    String image_url; // Assurez-vous que cette variable correspond au nom de clé JSON

    // Constructeur et getters/setters si nécessaire
    public Book(String title, String author, String image_url) {
        this.title = title;
        this.author = author;
        this.image_url = image_url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getImage_url() {
        return image_url;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getImageUrl() {
        return image_url;
    }
}
