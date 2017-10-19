package com.User.model;

public class UserAuth {

    private String token;
    private Integer userId;
    private Integer expire_Time;
    private String weChatOpenId;
    private Integer updateTime;



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUid(Integer userId) {
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
        auth.setUid(Integer.parseInt(userId));
        auth.setExpire_Time(2000);
        auth.setToken("20000");
        if(wechatOpenId!=null)
        {
            auth.setWeChatOpenId(wechatOpenId);
        }
        return auth;
    }


}
