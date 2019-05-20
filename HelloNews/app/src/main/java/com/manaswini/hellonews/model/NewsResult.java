package com.manaswini.hellonews.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResult {

    @SerializedName("articles")
    private List<News> newsList;

    public NewsResult(List<News> newsList) {
        this.newsList = newsList;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
