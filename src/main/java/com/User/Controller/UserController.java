package com.User.Controller;

import com.User.Constants.HTTPCodeConstants;
import com.User.Constants.HTTPMessageConstants;
import com.User.model.SMSCodeBean;
import com.User.model.UserAuth;
import com.User.services.*;
import com.Utils.SmsCodeUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.User.Dao.*;
import com.User.model.UserInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.Iterator;

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


    @Autowired
    private PhotoManagerService photoManagerService;



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

    @Autowired
    UploadFileService uploadFileService;
    @RequestMapping(value = "/uploadAvatarImage",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadFile(HttpServletRequest request, HttpServletResponse response)
    {
//        String token = request.getHeader("token");
        String userId = request.getParameter("userId");
        userId = "60001";
        JSONObject object = new JSONObject();
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(request))
        {
            MultipartHttpServletRequest multipartHttpServletRequest =
                    (MultipartHttpServletRequest)request;
            List<String> paths =
                    uploadFileService.saveFilePath(multipartHttpServletRequest.getFiles("headImage"),"56556333");
            UserInfo updateInfo =  new UserInfo();
            updateInfo.setUserId(userId);
            updateInfo.setAvatarUrl(paths.get(0));
            object = userInfoService.updateUserInfo(updateInfo);
        }else {
            MultipartHttpServletRequest multipartHttpServletRequest =
                    commonsMultipartResolver.resolveMultipart(request);

        }
        return object;
    }

    @RequestMapping("/user_images")
    @ResponseBody
    //获得个人的上传头像的数组
    public JSONObject getAllImages()
    {
       HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
       String userId = req.getParameter("userId");
       userId = "6001";
       JSONObject object = photoManagerService.getAllImagesBeans(userId);
       return object;
    }

    @RequestMapping(value = "/uploadImages",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadImages(HttpServletRequest request, HttpServletResponse response)
    {
        String userId = request.getHeader("userId");
        userId = "6001";
        JSONObject object = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(request))
        {
            MultipartHttpServletRequest multipartHttpServletRequest =
                    (MultipartHttpServletRequest)request;
            List<String> paths =
                            uploadFileService.saveFilePath(multipartHttpServletRequest.getFiles("image"),"56556333");
            object = photoManagerService.saveImageBeans(paths,userId);
        }else {
            MultipartHttpServletRequest multipartHttpServletRequest =
                    commonsMultipartResolver.resolveMultipart(request);

        }
        return object;
    }


}
