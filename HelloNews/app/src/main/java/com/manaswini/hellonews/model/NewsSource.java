package com.manaswini.hellonews.model;

import com.google.gson.annotations.SerializedName;

public class NewsSource {

    @SerializedName("id")
    private String mSourceId;

    @SerializedName("name")
    private String mSourceName;

    public NewsSource(String mSourceId, String mSourceName) {
        this.mSourceId = mSourceId;
        this.mSourceName = mSourceName;
    }

    public String getmSourceId() {
        return mSourceId;
    }

    public void setmSourceId(String mSourceId) {
        this.mSourceId = mSourceId;
    }

    public String getmSourceName() {
        return mSourceName;
    }

    public void setmSourceName(String mSourceName) {
        this.mSourceName = mSourceName;
    }
}
