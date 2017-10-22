package com.User.model;

import com.Utils.TokenUtils;
import sun.tools.jstat.Token;

import java.util.Date;

public class UserAuth {

    private String token;
    private String userId;
    private Integer expire_Time;
    private String weChatOpenId;
    private Integer updateTime;
    private String phone;

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public static UserAuth createAuthByUserId(String userId,String wechatOpenId,String phone)
    {
        UserAuth auth = new UserAuth();
        auth.setUid(userId);
        auth.setPhone(phone);
        auth.setWeChatOpenId(wechatOpenId);
        auth.setExpire_Time((int)(new Date().getTime()));
        String token = TokenUtils.createToken(phone);
        auth.setToken(token.substring(0,28));
        return auth;
    }
}
