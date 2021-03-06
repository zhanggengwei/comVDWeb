package com.Utils;

import com.User.model.UserInfo;
import com.firebase.security.token.TokenGenerator;
import com.firebase.security.token.TokenOptions;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;

public class TokenUtils
{
    public static String  createToken(String phone)
    {
        TokenGenerator generator = new TokenGenerator(""+"vd");
        TokenOptions options = new TokenOptions();
        options.setAdmin(true);
        options.setDebug(true);
        Date currentDate = new Date();
        options.setNotBefore(currentDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        String token = null;
        calendar.add(Calendar.MILLISECOND,60*24*60*1000);
        options.setExpires(new Date(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)));
        try {
            JSONObject object = new JSONObject("{msg:2}");
            token = generator.createToken(object, options);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return "" + System.currentTimeMillis();
    }
}
