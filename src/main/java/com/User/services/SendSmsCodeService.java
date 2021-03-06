package com.User.services;

import com.Sms.service.SmsCodeMessage;
import com.User.Constants.HTTPCodeConstants;
import com.User.Constants.HTTPMessageConstants;
import com.Utils.SmsCodeUtils;
import com.alibaba.fastjson.JSONObject;
import com.Sms.service.SmsCodeEnum;
import org.springframework.stereotype.Service;

//验证码短信发送
@Service("sendSmsCodeService")
public class SendSmsCodeService
{
    public JSONObject sendSmsCode(String phone,SmsCodeEnum codeEnum) {
        //尝试使用发邮件代替发送手机的验证码的短信
//          尝试生成随机数
        String smsCode = SmsCodeUtils.createRandomCode();
        String message = SmsCodeMessage.REGISTER_SMS_MESSAGE;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSONObject object = new JSONObject();
        object.put("code", HTTPCodeConstants.SUCESS_CODE);
        object.put("msg", HTTPMessageConstants.SUCESS_MESSAGE);
        return object;
    }
}
