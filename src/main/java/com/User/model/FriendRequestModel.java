package com.User.model;

public class FriendRequestModel
{
    //status 0 表示请求未处理 1表示同意 2 表示已经添加
    private String requestId;
    private String userId;
    private String q_userId;
    private String q_message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private Integer status;
    private Boolean isDelete;

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQ_userId() {
        return q_userId;
    }

    public void setQ_userId(String q_userId) {
        this.q_userId = q_userId;
    }

    public String getQ_message() {
        return q_message;
    }

    public void setQ_message(String q_message) {
        this.q_message = q_message;
    }

}
