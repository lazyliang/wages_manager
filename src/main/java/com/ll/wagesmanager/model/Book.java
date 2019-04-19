package com.ll.wagesmanager.model;

import java.io.Serializable;

public class Book implements Serializable {
    public Book(String id, String bookName, String author, String publicationDate, String abstracts) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.publicationDate = publicationDate;
        this.abstracts = abstracts;
    }
    public Book(){}

    private String id;
    private String bookName;
    private String author;
    private String publicationDate;
    private String abstracts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }
}
