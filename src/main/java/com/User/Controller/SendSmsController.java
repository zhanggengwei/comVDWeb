package com.User.Controller;

import com.User.Constants.HTTPCodeConstants;
import com.User.Constants.HTTPMessageConstants;
import com.User.Constants.SMSMessageType;
import com.User.services.SendSmsCodeService;
import com.Sms.service.SmsCodeEnum;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//进行短信的处理
@Controller
@RequestMapping(value = "/sms")
public class SendSmsController
{
    @Autowired
    SendSmsCodeService sendSmsCodeService;

    @RequestMapping("/SmsCode")
    @ResponseBody
    public JSONObject sendSmsCode(String phone,Integer smsType)
    {
        Integer type = SMSMessageType.login_sms;
        switch (type)
        {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }


        JSONObject object = null;
        if (phone==null)
        {
            object= new JSONObject();
            object.put("code", HTTPCodeConstants.PARAMATER_LACK_CODE);
            object.put("msg", HTTPMessageConstants.PARAMATER_LACK_MESSAGE);
        }else
        {
            SmsCodeEnum codeEnum = null;
            object = sendSmsCodeService.sendSmsCode(phone,codeEnum);

        }
       return object;
    }
}
