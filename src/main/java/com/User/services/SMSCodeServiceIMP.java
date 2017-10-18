package com.User.services;

import com.User.Dao.SMSCodeMapper;
import com.User.Dao.SMSMessageMapper;
import com.User.model.SMSCodeBean;
import org.apache.taglibs.standard.util.EscapeXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("smsCodeService")
@Transactional
public class SMSCodeServiceIMP implements SMSCodeService{
    @Autowired
    SMSMessageMapper smsMessageMapper;

    @Autowired
    SMSCodeMapper codeMapper;

    @Override
    public String searchSMSCodeMessage(Integer smsType) {
        String msg = null;
        try
        {
            msg = smsMessageMapper.searchMessageContent(smsType);

        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return msg;
    }

    @Override
    public Boolean addOrUpdate(SMSCodeBean bean) {

        Boolean flag = false;
        try
        {
            flag = codeMapper.insertSmsCodeBean(bean) > 0;
        }catch (Exception  e)
        {
            throw new RuntimeException(e);
        }
        return flag;
    }

    @Override
    public SMSCodeBean searchSmsBeanByPhone(String phone) {
        SMSCodeBean bean = null;
        try
        {
            bean = codeMapper.searchSmsCodeBeanByPhone(phone);
        }catch (Exception  e)
        {
            throw new RuntimeException(e);
        }
        return bean;
    }
}
