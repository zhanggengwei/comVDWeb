package com.User.services;

import com.User.model.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;

public interface UserInfoService
{
    public JSONObject registerUserInfo(UserInfo info);

    public JSONObject loginUserInfo(String phone,String passWord);

    public JSONObject searchUserInfoByPhone(String phone);

    public JSONObject searchUserInfoByUid(String uid);

    public JSONObject updateUserInfo(UserInfo inf);

    public JSONObject resetPassWord(UserInfo info,String smsCode);

    //更改手机密码
    public JSONObject updatePassWord(String userId,String oldPassWord,String passWord, String smsCode);

    //修改头像的地址

    public JSONObject updateUserAvatarUrl(String avatarUrl,String userId);

}
