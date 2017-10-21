package com.User.services;

import com.User.Constants.HTTPCodeConstants;
import com.User.Constants.HTTPMessageConstants;
import com.User.Dao.*;
import com.User.Utils.MD5Utils;
import com.User.model.*;
import com.Utils.TokenUtils;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.ExecutionError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userInfoService")
@Transactional
public class UserInfoServiceIMP implements UserInfoService {
    @Autowired
    UserInfoMapper userMapper;
    @Autowired
    UserAuthMapper authMapper;
    @Autowired
    SMSCodeMapper smsCodeMapper;

    @Autowired
    classMapper mapper;


    @Transactional
    public JSONObject loginUserInfo(String phone, String passWord) {
        JSONObject object = new JSONObject();
        //加密密码
        passWord = MD5Utils.md5String(passWord);
        UserInfo info = null;
        try {
//            List<OrderUserCustom> list = orderMapper.findOrderUserList();
             Classes list = mapper.getClass(1);

            info = this.userMapper.loginUserInfo(phone,passWord);
            if(info==null)
            {
                 object.put("code", HTTPCodeConstants.PHONE_PASSWORD_ERROR_CODE);
                 object.put("msg", HTTPMessageConstants.PHONE_PASSWORD_ERROR_MESSAGE);
                 return object;
            }
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        object.put("code", HTTPCodeConstants.SUCESS_CODE);
        object.put("msg", HTTPMessageConstants.SUCESS_MESSAGE);
        object.put("result",info);
        return object;
    }
    @Transactional
    public JSONObject registerUserInfo(UserInfo info) {
        JSONObject object = new JSONObject();
        UserInfo searchUserInfo = null;
        try
        {
            searchUserInfo = this.userMapper.searchUserInfoByPhone(info.getPhone());
            if(searchUserInfo!=null)
            {
                object.put("msg", HTTPMessageConstants.PHONE_EXISTS_MESSAGE);
                object.put("code", HTTPMessageConstants.SUCESS_MESSAGE);
            }
            else {
                userMapper.registerUserInfo(info);
                UserAuth auth = UserAuth.createAuthByUserId(info.getUserId(),null,info.getPhone());
                authMapper.insert_Auth(auth);
                object.put("code", HTTPCodeConstants.SUCESS_CODE);
                object.put("msg", HTTPMessageConstants.SUCESS_MESSAGE);
                object.put("result", info);
            }
        }
        catch(Exception exception)
        {
            throw new RuntimeException(exception);
        }
        return object;
    }

    public JSONObject searchUserInfoByUid(String uid)
    {
        JSONObject object = new JSONObject();
        try {
            UserInfo userInfo = this.userMapper.searchUserInfoByUid(uid);

            if(userInfo==null)
            {
                 object.put("code", HTTPCodeConstants.UID_ERROR_CODE);
                 object.put("msg", HTTPMessageConstants.UID_ERROR_MESSAGE);
            }
            else
            {
                object.put("code", HTTPCodeConstants.SUCESS_CODE);
                object.put("msg", HTTPMessageConstants.SUCESS_MESSAGE);
                object.put("result",userInfo);
            }
        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }

        return object;
    }
    public JSONObject searchUserInfoByPhone(String phone)
    {
        JSONObject object = new JSONObject();
        try {
            UserInfo userInfo = this.userMapper.searchUserInfoByPhone(phone);

            if(userInfo==null)
            {
                object.put("code", HTTPCodeConstants.PHONE_NOT_EXITS_CODE);
                object.put("msg", HTTPMessageConstants.PHONE_NOT_EXISTS_MESSAGE);
            }
            else
            {
                object.put("code", HTTPCodeConstants.SUCESS_CODE);
                object.put("msg", HTTPMessageConstants.SUCESS_MESSAGE);
                object.put("result",userInfo);
            }
        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }

        return object;
    }

    @Override
    public JSONObject updateUserInfo(UserInfo info) {
        JSONObject object = new JSONObject();
        try {
            userMapper.updateUserInfo(info);
            object.put("code",HTTPCodeConstants.SUCESS_CODE);
            object.put("msg",HTTPMessageConstants.SUCESS_MESSAGE);
            object.put("result",info.getAvatarUrl());
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return object;
    }

    @Transactional
    @Override
    public JSONObject resetPassWord(UserInfo info,String smsCode) {

        JSONObject object = new JSONObject();
        if(info.getPassWord()==null||info.getPhone()==null)
        {
            object.put("code",HTTPCodeConstants.PARAMATER_LACK_CODE);
            object.put("msg",HTTPMessageConstants.PARAMATER_LACK_MESSAGE);
        }
        try {
            UserAuth auth = UserAuth.createAuthByUserId(info.getUserId(),null,info.getPhone());
            userMapper.resetPassWord(info,smsCode);
            authMapper.update_AuthToken(auth);
            UserInfo currentInfo = userMapper.customUserInfo(info.getPhone());
            if(currentInfo==null)
            {
                object.put("code",HTTPCodeConstants.PHONE_NOT_EXITS_CODE);
                object.put("msg",HTTPMessageConstants.PHONE_NOT_EXISTS_MESSAGE);
            }else {

                SMSCodeBean bean = smsCodeMapper.searchSmsCodeBeanByPhone(info.getPhone());
                if(bean==null)
                {
                    object.put("code",HTTPCodeConstants.SMS_CODE_LACK);
                    object.put("msg",HTTPMessageConstants.SMS_CODE_LACK_MESSAGE);

                }else
                {
                    if(!bean.getSmsCode().equals(smsCode))
                    {
                        object.put("code",HTTPCodeConstants.SMS_CODE_ERROR);
                        object.put("msg",HTTPMessageConstants.SMS_CODE_ERROR_MESSAGE);

                    }else {


                        object.put("code", HTTPCodeConstants.SUCESS_CODE);
                        object.put("msg", HTTPMessageConstants.SUCESS_MESSAGE);
                        object.put("result", currentInfo);
                    }
                }
            }
        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }
        return object;
    }

    @Override
    @Transactional
    public JSONObject updatePassWord(String userId,String oldPassWord,String passWord, String smsCode) {
        //修改密码 userId smsCode oldPassWord newPassWord

        JSONObject object = new JSONObject();
        try {
            SMSCodeBean smsCodeBean = smsCodeMapper.judgeSmsCodeIsValid(userId);
            if(smsCodeBean==null)
            {
               throw new RuntimeException(new Exception("请发送手机验证码"));
            }
//            if(smsCodeBean.getExpire_time()==0)
//            {
//                throw new RuntimeException(new Exception("验证码过期"));
//            }
            if(userMapper.updatePassWord(oldPassWord,userId,passWord)>0)
            {
                UserAuth auth = UserAuth.createAuthByUserId(userId,null,null);
                authMapper.update_AuthToken(auth);
                object.put("code",HTTPCodeConstants.SUCESS_CODE);
                object.put("msg",HTTPMessageConstants.SUCESS_MESSAGE);
            }else
            {
                throw  new RuntimeException(new Exception("密码错误"));
            }
        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }
        return object;
    }

    @Override
    public JSONObject updateUserAvatarUrl(String avatarUrl, String userId) {
        JSONObject object = new JSONObject();
        try {
            userMapper.updateAvatarUrl(avatarUrl, userId);
            object.put("code",HTTPCodeConstants.SUCESS_CODE);
            object.put("msg",HTTPMessageConstants.SUCESS_MESSAGE);
            object.put("result",avatarUrl);
        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }
        return object;
    }

}