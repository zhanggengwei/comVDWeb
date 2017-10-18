package com.User.Controller;

import com.User.Constants.HTTPCodeConstants;
import com.User.Constants.HTTPMessageConstants;
import com.User.model.SMSCodeBean;
import com.User.model.UserAuth;
import com.User.services.SMSCodeService;
import com.User.services.UserInfoAuthService;
import com.User.services.UserInfoService;
import com.Utils.SmsCodeUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.User.Dao.*;
import com.User.model.UserInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UserController.class);

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SMSCodeService smsCodeService;

    @Autowired
    private SmsCodeUtils codeUtils;

    @RequestMapping("/register")
    @ResponseBody
    public JSONObject registerUserInfo(UserInfo info)
    {
        JSONObject object;
        if(info.getPassWord()==null||info.getPhone()==null||info.getName()==null
                ||info.getRegion()==null)
        {
            object = new JSONObject();
            object.put("code", HTTPCodeConstants.PARAMATER_LACK_CODE);
            object.put("msg", HTTPMessageConstants.PARAMATER_LACK_MESSAGE);

        }else
        {
             object = this.userInfoService.registerUserInfo(info);
        }
        return object;
    }
    @RequestMapping("/login")
    @ResponseBody
    public JSONObject LogInUserInfo(UserInfo info)
    {
        JSONObject object;
        if(info.getPhone()==null||info.getPassWord()==null)
        {
            object = new JSONObject();
            object.put("code", HTTPCodeConstants.PARAMATER_LACK_CODE);
            object.put("msg", HTTPMessageConstants.PARAMATER_LACK_MESSAGE);
        }else
        {
            object = this.userInfoService.loginUserInfo(info.getPhone(),info.getPassWord());
        }
        return object;
    }

    @RequestMapping("/searchUserByPhone")
    @ResponseBody
    public JSONObject searchUserByPhone(String phone)
    {
        //HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
       // HttpServletResponse resp = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
        JSONObject object;
        if(phone==null)
        {
            object = new JSONObject();
            object.put("code", HTTPCodeConstants.PARAMATER_LACK_CODE);
            object.put("msg", HTTPMessageConstants.PARAMATER_LACK_MESSAGE);
        }else
        {
            object = this.userInfoService.searchUserInfoByPhone(phone);
        }
        return object;
    }

    @RequestMapping("/resetPassWord")
    @ResponseBody
    public JSONObject resetPassWord(String phone,String passWord,String region,String smsCode)
    {
        if(region==null)
        {
            region = "86";
        }
        UserInfo info = new UserInfo();
        info.setPhone(phone);
        info.setPassWord(passWord);
        info.setRegion(passWord);
        JSONObject object = userInfoService.resetPassWord(info,smsCode);
        return object;
    }

    @RequestMapping("/sendSms")
    @ResponseBody
    public  JSONObject sendSmsCode(String phone,String region,Integer smsType)
    {
        if(region==null)
        {
            region = "86";
        }
        if(phone==null||region==null)
        {
            JSONObject object = new JSONObject();
            object.put("code",HTTPCodeConstants.PARAMATER_LACK_CODE);
            object.put("msg",HTTPMessageConstants.PARAMATER_LACK_MESSAGE);
            return object;
        }
        return  codeUtils.sendCode(phone,1);
    }


}
