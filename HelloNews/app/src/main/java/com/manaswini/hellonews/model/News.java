package com.manaswini.hellonews.model;

import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("source")
    private NewsSource mSource;

    @SerializedName("title")
    private String mNewsTitle;

    @SerializedName("urlToImage")
    private String mNewsImage;

    @SerializedName("author")
    private String mNewsAuthor;

    @SerializedName("url")
    private String mBrowserLink;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("publishedAt")
    private String mPublishedDate;

    public NewsSource getmSource() {
        return mSource;
    }

    public void setmSource(NewsSource mSource) {
        this.mSource = mSource;
    }

    public String getmNewsTitle() {
        return mNewsTitle;
    }

    public void setmNewsTitle(String mNewsTitle) {
        this.mNewsTitle = mNewsTitle;
    }

    public String getmNewsImage() {
        return mNewsImage;
    }

    public void setmNewsImage(String mNewsImage) {
        this.mNewsImage = mNewsImage;
    }

    public String getmNewsAuthor() {
        return mNewsAuthor;
    }

    public void setmNewsAuthor(String mNewsAuthor) {
        this.mNewsAuthor = mNewsAuthor;
    }

    public String getmBrowserLink() {
        return mBrowserLink;
    }

    public void setmBrowserLink(String mBrowserLink) {
        this.mBrowserLink = mBrowserLink;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmPublishedDate() {
        return mPublishedDate;
    }

    public void setmPublishedDate(String mPublishedDate) {
        this.mPublishedDate = mPublishedDate;
    }

    public News(NewsSource mSource, String mNewsTitle, String mNewsImage, String mNewsAuthor, String mBrowserLink, String mDescription, String mPublishedDate) {
        this.mSource = mSource;
        this.mNewsTitle = mNewsTitle;
        this.mNewsImage = mNewsImage;
        this.mNewsAuthor = mNewsAuthor;
        this.mBrowserLink = mBrowserLink;
        this.mDescription = mDescription;
        this.mPublishedDate = mPublishedDate;
    }
}
