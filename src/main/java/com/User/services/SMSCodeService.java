package com.User.services;

import com.User.model.SMSCodeBean;

public interface SMSCodeService {

    public Boolean addOrUpdate(SMSCodeBean bean);

    public SMSCodeBean searchSmsBeanByPhone(String phone);

    public String searchSMSCodeMessage(Integer smsType);



}
