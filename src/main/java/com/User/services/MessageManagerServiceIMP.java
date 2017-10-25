package com.User.services;

import com.User.Constants.HTTPCodeConstants;
import com.User.Constants.HTTPMessageConstants;
import com.User.Dao.MessageMapper;
import com.User.model.Message;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("messageService")
public class MessageManagerServiceIMP implements MessageManagerService
{

    @Autowired
    MessageMapper messageMapper;

    @Override
    public JSONObject deleteMessage(Integer messageId) {



        return null;
    }
    @Transactional
    @Override
    public JSONObject insertMessages(List<Message> messages) {
        JSONObject object = new JSONObject();
        try {
            messageMapper.insertMessages(messages);
            object.put("code", HTTPCodeConstants.SUCESS_CODE);
            object.put("msg", HTTPMessageConstants.SUCESS_MESSAGE);
            object.put("result",messages);
        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }

        return object;
    }

    @Override
    public JSONObject getListMessages(String contactId) {
        JSONObject object = new JSONObject();
        try
        {
            List<Message> messages = messageMapper.allListMessages(contactId);
            object.put("code", HTTPCodeConstants.SUCESS_CODE);
            object.put("msg", HTTPMessageConstants.SUCESS_MESSAGE);
            object.put("result",messages);

        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }
        return object;
    }

    @Override
    public JSONObject updateMessageStatus(Integer status, Integer messageId) {
        JSONObject jsonObject = new JSONObject();
        try {
            messageMapper.updateMessageStatus(status,messageId);
            jsonObject.put("code", HTTPCodeConstants.SUCESS_CODE);
            jsonObject.put("msg", HTTPMessageConstants.SUCESS_MESSAGE);

        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }
        return null;
    }
}
