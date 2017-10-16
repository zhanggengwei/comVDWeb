package com.User.Dao;
import  com.User.model.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface UserDao {
    public User getUserNameByMsisdn(String userMsisdn);
}
