package com.kao.elasticsearch.bean;


import org.springframework.data.elasticsearch.annotations.Document;

//跟mongodb類似
@Document(indexName = "chun")
public class Book {
    private Integer id;
    private String author;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
