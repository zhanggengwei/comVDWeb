package com.User.services;

import com.User.Constants.UserInfoCodeConstants;
import com.User.Constants.UserInfoMessageConstants;
import com.User.Dao.UserDao;
import com.User.Dao.UserInfoMapper;
import com.User.Utils.MD5Utils;
import com.User.model.UserInfo;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;

@Service("userInfoService")
@Transactional
public class UserInfoServiceIMP implements UserInfoService {
    @Autowired
    UserInfoMapper userMapper;
    public JSONObject loginUserInfo(String phone, String passWord) {
        JSONObject object = new JSONObject();
        //加密密码
        passWord = MD5Utils.md5String(passWord);
        UserInfo info = null;
        try {
            info = this.userMapper.searchUserInfoByPhone(phone);
            if(info==null||(!info.getPassWord().equals(passWord)))
            {
                 object.put("code",UserInfoCodeConstants.PHONE_PASSWORD_ERROR_CODE);
                 object.put("msg",UserInfoMessageConstants.PHONE_PASSWORD_ERROR_MESSAGE);
                 return object;
            }
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        object.put("code", UserInfoCodeConstants.SUCESS_CODE);
        object.put("msg", UserInfoMessageConstants.SUCESS_MESSAGE);
        object.put("result",info);
        return object;
    }
    public JSONObject registerUserInfo(UserInfo info) {
        JSONObject object = new JSONObject();
        UserInfo searchUserInfo = null;
        try
        {
            searchUserInfo = this.userMapper.searchUserInfoByPhone(info.getPhone());
            if(searchUserInfo!=null)
            {
                object.put("msg",UserInfoMessageConstants.PHONE_EXISTS_MESSAGE);
                object.put("code",UserInfoMessageConstants.SUCESS_MESSAGE);
            }
            else {
                userMapper.registerUserInfo(info);
                object.put("code", UserInfoCodeConstants.SUCESS_CODE);
                object.put("msg", UserInfoMessageConstants.SUCESS_MESSAGE);
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
                 object.put("code",UserInfoCodeConstants.UID_ERROR_CODE);
                 object.put("msg",UserInfoMessageConstants.UID_ERROR_MESSAGE);
            }
            else
            {
                object.put("code",UserInfoCodeConstants.SUCESS_CODE);
                object.put("msg",UserInfoMessageConstants.SUCESS_MESSAGE);
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
                object.put("code",UserInfoCodeConstants.PHONE_NOT_EXITS_CODE);
                object.put("msg",UserInfoMessageConstants.PHONE_NOT_EXISTS_MESSAGE);
            }
            else
            {
                object.put("code",UserInfoCodeConstants.SUCESS_CODE);
                object.put("msg",UserInfoMessageConstants.SUCESS_MESSAGE);
                object.put("result",userInfo);
            }
        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }

        return object;
    }

    @Override
    public JSONObject updateUserInfo(UserInfo inf) {
        JSONObject object = new JSONObject();

        return null;
    }
}