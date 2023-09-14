package com.example.w3d3restclient;

public class Book {

    private Integer id;
    private String ISBN;
    private String author;
    private double price;
    private String title;
    public Book(String ISBN, String author, double price, String title) {
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        this.title = title;
    }

    public Book() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
       return  String.format("Title: %s, Author: %s, ISBN: %s, Price: %.2f", title, author, ISBN, price);
    }
}
