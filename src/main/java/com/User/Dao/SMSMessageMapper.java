package com.User.Dao;

import org.springframework.stereotype.Repository;

@Repository
public interface SMSMessageMapper {
    public String searchMessageContent(Integer smsCodeType);
}
