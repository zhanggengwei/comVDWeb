package com.User.Dao;

import com.User.model.UserAuth;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthMapper
{
    public int update_AuthToken(UserAuth model);

    public UserAuth searchByToken(String token);

    public int insert_Auth(UserAuth model);

    public UserAuth searchByWeChatOpenId(String weChatOpenId);




}
