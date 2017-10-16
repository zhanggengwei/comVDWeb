package com.User.Controller;

import com.User.Constants.UserInfoCodeConstants;
import com.User.Constants.UserInfoMessageConstants;
import com.User.services.SendSmsCodeService;
import com.Sms.service.SmsCodeEnum;
import com.alibaba.fastjson.JSON;
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
    public JSONObject sendSmsCode(String phone)
    {
        JSONObject object = null;
        if (phone==null)
        {
            object= new JSONObject();
            object.put("code", UserInfoCodeConstants.PARAMATER_LACK_CODE);
            object.put("msg", UserInfoMessageConstants.PARAMATER_LACK_MESSAGE);
        }else
        {
            SmsCodeEnum codeEnum = null;
            object = sendSmsCodeService.sendSmsCode(phone,codeEnum);

        }
       return object;
    }
}
