package com.User.model;

public class SMSCodeBean
{
    private String phone;
    private String smsCode;
    private long  expire_time;
    private long  updateAt;
    private Integer smsCodeType;
    private String region;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public long getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(long expire_time) {
        this.expire_time = expire_time;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getSmsCodeType() {
        return smsCodeType;
    }

    public void setSmsCodeType(Integer smsCodeType) {
        this.smsCodeType = smsCodeType;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }
    public String getRegion()
    {
        return this.region;
    }

}