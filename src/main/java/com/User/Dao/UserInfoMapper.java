package com.User.Dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.User.model.UserInfo;

@Repository
public interface UserInfoMapper {
    public int registerUserInfo(UserInfo entity);

    public UserInfo loginUserInfo(@Param("phone") String phone, @Param("passWord") String passWord);

    public UserInfo searchUserInfoByUid(@Param("userId") String userId);

    public UserInfo searchUserInfoByPhone(@Param("phone") String phone);

    public int updateUserInfo(@Param("userInfo") UserInfo userInfo);
}
