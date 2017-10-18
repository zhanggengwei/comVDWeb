package com.Utils;

import com.User.Constants.HTTPCodeConstants;
import com.User.Constants.HTTPMessageConstants;
import com.User.Constants.SMSMessageType;
import com.User.model.SMSCodeBean;
import com.User.services.SMSCodeService;
import com.User.services.UserInfoService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service("smsCodeUtils")
public class SmsCodeUtils
{

    @Autowired
    private SMSCodeService smsCodeService;

    //提供一个方法用于生成六位数字的验证码
    public static String createRandomCode()
    {
        Random random = new Random();
        int uid = random.nextInt(1000000);
        uid = uid|99999;
        String smsCode = String.valueOf(uid);
        if(smsCode.length()==5)
        {
            smsCode= "0"+smsCode;
        }
        return smsCode;
    }
    //
    public JSONObject sendCode(String phone, final Integer smsType)
    {

        String message = smsCodeService.searchSMSCodeMessage(smsType);
        //模拟发送短信的验证码的发送
        String code = createRandomCode();

        SMSCodeBean bean = new SMSCodeBean();
        bean.setSmsCode(code);
        bean.setPhone(phone);
        bean.setExpire_time(System.currentTimeMillis());
        bean.setSmsCodeType(smsType);
        smsCodeService.addOrUpdate(bean);

        JSONObject object = new JSONObject();
        object.put("code", HTTPCodeConstants.SUCESS_CODE);
        object.put("msg", HTTPMessageConstants.SUCESS_MESSAGE);
        return object;
    }
}
