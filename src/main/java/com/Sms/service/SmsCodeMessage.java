package com.Sms.service;

public interface SmsCodeMessage
{
    static public Integer SMSCODE = 0;
    public String REGISTER_SMS_MESSAGE = "您的手机验证码是"+"<a href="+SMSCODE.toString()+"/a> ,有效期30分钟祝您健康";
    public String RESET_PASS_WORD_SMS_MESSAGE = "您的手机验证码是"+"<a href="+SMSCODE.toString()+"/a> ,有效期30分钟祝您健康";
    public String LOGIN_SMS_MESSAGE = "您的手机验证码是"+"<a href="+SMSCODE.toString()+"/a> ,有效期30分钟祝您健康";
    public String CHANGE_PHONE_SMS_MESSAGE = "您的手机验证码是"+"<a href="+SMSCODE.toString()+"/a> ,有效期30分钟祝您健康";
    public String BIND_WECHAT_OPENID_SMS_MESSAGE = "您的手机验证码是"+"<a href="+SMSCODE.toString()+"/a> ,有效期30分钟祝您健康";
}
