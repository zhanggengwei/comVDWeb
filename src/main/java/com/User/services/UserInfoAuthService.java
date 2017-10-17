package com.User.services;

import com.User.model.UserAuth;
import org.springframework.stereotype.Service;


public interface UserInfoAuthService {
    public Boolean insertAuth(UserAuth auth);

    public UserAuth searchAuthByWeChatOpenId(String openId);

    public UserAuth searchAuthByToken(String token);

    public Boolean updateAuth(UserAuth auth);
}
