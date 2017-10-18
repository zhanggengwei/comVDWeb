package com.User.services;

import com.User.Dao.UserAuthMapper;
import com.User.model.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("authService")
@Transactional
public class UserInfoAuthServiceIMP implements UserInfoAuthService{

    @Autowired
    UserAuthMapper authMapper;

    @Override
    public Boolean insertAuth(UserAuth auth) {

        try {
            return authMapper.insert_Auth(auth) > 0;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserAuth searchAuthByWeChatOpenId(String openId) {

        try {
            return authMapper.searchByWeChatOpenId(openId);
        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public UserAuth searchAuthByToken(String token) {
        try {
            return authMapper.searchByToken(token);

        }catch (Exception e)
        {
            throw new RuntimeException(e) ;
        }
    }

    @Override
    public Boolean updateAuth(UserAuth auth) {
        try {

            return authMapper.update_AuthToken(auth)>0;
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
