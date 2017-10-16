package com.User.services;

import com.User.Constants.UserInfoCodeConstants;
import com.User.Constants.UserInfoMessageConstants;
import com.User.Dao.MessageMapper;
import com.User.model.Message;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.taglibs.standard.util.EscapeXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public JSONObject insertMessages(Message message) {
        JSONObject object = new JSONObject();
        try {
            Integer messageID = messageMapper.insertMessage(message);
            object.put("code", UserInfoCodeConstants.SUCESS_CODE);
            object.put("msg",UserInfoMessageConstants.SUCESS_MESSAGE);
            object.put("result",message);
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
            object.put("code",UserInfoCodeConstants.SUCESS_CODE);
            object.put("msg",UserInfoMessageConstants.SUCESS_MESSAGE);
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
            jsonObject.put("code",UserInfoCodeConstants.SUCESS_CODE);
            jsonObject.put("msg",UserInfoMessageConstants.SUCESS_MESSAGE);

        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }
        return null;
    }
}
