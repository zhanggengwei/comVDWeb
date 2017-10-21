package com.User.Dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.User.model.UserInfo;

@Repository
public interface UserInfoMapper {
    public int registerUserInfo(UserInfo entity);

    public UserInfo loginUserInfo(@Param("phone") String phone, @Param("passWord") String passWord);

    public UserInfo searchUserInfoByUid(@Param("userId") String userId);

    public UserInfo customUserInfo(@Param("phone")String  phone);

    public UserInfo searchUserInfoByPhone(@Param("phone") String phone);

    public int updateUserInfo(UserInfo userInfo);

    public int updatePassWord(@Param("oldPassWord") String oldPassWord,@Param("userId") String userId,@Param("newPassWord")String  newPassWord);

    public int updateAvatarUrl(@Param("avatarUrl") String avatarUrl,@Param("userId") String userId);

    public int resetPassWord(@Param("userInfo") UserInfo userInfo,@Param("smsCode") String smsCode);



}
