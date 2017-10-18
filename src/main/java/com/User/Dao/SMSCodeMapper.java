package com.User.Dao;

import com.User.model.SMSCodeBean;
import org.springframework.stereotype.Repository;


@Repository
public interface SMSCodeMapper {

    public SMSCodeBean searchSmsCodeBeanByPhone(String phone);

    public int  insertSmsCodeBean(SMSCodeBean bean);

    public int  updateSmsCodeBean(SMSCodeBean bean);





}
