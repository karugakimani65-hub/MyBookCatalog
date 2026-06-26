package com.example.mybookcatalog;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String description;
    private String genre;
    private int numChapters;
    private int coverImageResId;
    private String previewChapters;

    public Book(String title, String author, String description, String genre, int numChapters, int coverImageResId, String previewChapters) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.genre = genre;
        this.numChapters = numChapters;
        this.coverImageResId = coverImageResId;
        this.previewChapters = previewChapters;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public int getNumChapters() {
        return numChapters;
    }

    public int getCoverImageResId() {
        return coverImageResId;
    }

    public String getPreviewChapters() {
        return previewChapters;
    }
}
