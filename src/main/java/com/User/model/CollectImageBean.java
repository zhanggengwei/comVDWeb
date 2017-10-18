package com.User.model;

public class CollectImageBean {

    private String userId;
    private String sourceUrl;
    private Integer imageId;
    private boolean idDelete;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public boolean isIdDelete() {
        return idDelete;
    }

    public void setIdDelete(boolean idDelete) {
        this.idDelete = idDelete;
    }

}
