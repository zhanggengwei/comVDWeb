package com.User.Dao;

import com.User.model.SMSCodeBean;
import org.springframework.stereotype.Repository;


@Repository
public interface SMSCodeMapper {

    public SMSCodeBean searchSmsCodeBeanByPhone(String phone);

    public int  saveOrUpdate(SMSCodeBean bean);
    //判断验证码是否正确
    public SMSCodeBean judgeSmsCodeIsValid(String useId);



}
