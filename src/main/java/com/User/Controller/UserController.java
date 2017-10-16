package com.User.Controller;

import com.User.Constants.UserInfoCodeConstants;
import com.User.Constants.UserInfoMessageConstants;
import com.User.services.UserInfoService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.User.Dao.*;
import com.User.model.UserInfo;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UserController.class);

    @Autowired
    private  UserInfoMapper userInfoMapper;
    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/register")
    @ResponseBody
    public JSONObject registerUserInfo(UserInfo info)
    {
        JSONObject object;
        if(info.getPassWord()==null||info.getPhone()==null||info.getName()==null
                ||info.getRegion()==null)
        {
            object = new JSONObject();
            object.put("code", UserInfoCodeConstants.PARAMATER_LACK_CODE);
            object.put("msg", UserInfoMessageConstants.PARAMATER_LACK_MESSAGE);

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
            object.put("code", UserInfoCodeConstants.PARAMATER_LACK_CODE);
            object.put("msg", UserInfoMessageConstants.PARAMATER_LACK_MESSAGE);
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
        JSONObject object;
        if(phone==null)
        {
            object = new JSONObject();
            object.put("code", UserInfoCodeConstants.PARAMATER_LACK_CODE);
            object.put("msg", UserInfoMessageConstants.PARAMATER_LACK_MESSAGE);
        }else
        {
            object = this.userInfoService.searchUserInfoByPhone(phone);
        }
        return object;
    }
}
