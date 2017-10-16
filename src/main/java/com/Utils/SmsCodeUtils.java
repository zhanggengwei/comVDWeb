package com.Utils;

import java.util.Random;

public class SmsCodeUtils
{
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
}
