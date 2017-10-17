package com.User.model;

public class UserAuth {

    private String token;
    private Integer uid;
    private Integer expire_Time;
    private String weChatOpenId;
    private Integer updateTime;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getExpire_Time() {
        return expire_Time;
    }

    public void setExpire_Time(Integer expire_Time) {
        this.expire_Time = expire_Time;
    }

    public String getWeChatOpenId() {
        return weChatOpenId;
    }

    public void setWeChatOpenId(String weChatOpenId) {
        this.weChatOpenId = weChatOpenId;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }


}
