package com.daza.edner.myomdbproject.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RatingsEntity implements Serializable {
    @SerializedName("Value")
    private String value;
    @SerializedName("Source")
    private String source;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
