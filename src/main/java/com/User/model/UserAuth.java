package com.User.model;

import java.util.Date;

public class UserAuth {

    private String token;
    private String userId;
    private Integer expire_Time;
    private String weChatOpenId;
    private Integer updateTime;



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUid(String userId) {
        this.userId = userId;
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

    public boolean tokenIsValid()
    {
        return true;
    }

    public static UserAuth createAuthByUserId(String userId,String wechatOpenId)
    {
        UserAuth auth = new UserAuth();
        auth.setUid(userId);
        auth.setExpire_Time((int)(new Date().getTime()));
        String token = Integer.toString((int) System.currentTimeMillis());
        auth.setToken(token);
        if(wechatOpenId!=null)
        {
            auth.setWeChatOpenId(wechatOpenId);
        }
        return auth;
    }


}
