package com.User.Dao;

import com.User.model.UserAuth;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthMapper
{
    //通过手机号码修改或者是通过userId修改用户的auth
    public int update_AuthToken(UserAuth model);

    public UserAuth searchByToken(String token);
    //
    public int insert_Auth(UserAuth model);

    public UserAuth searchByWeChatOpenId(String weChatOpenId);


}
