package com.User.services;

import java.util.List;
import com.User.model.Message;
import com.alibaba.fastjson.JSONObject;

public interface MessageManagerService {

    public JSONObject deleteMessage(Integer messageId);
    //插入多条消息的记录
    public JSONObject insertMessages(List<Message> message);

    public JSONObject getListMessages(String contactId);

    public JSONObject updateMessageStatus(Integer status,Integer messageId);

}
