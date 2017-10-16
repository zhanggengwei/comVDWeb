package com.User.services;

import com.User.model.Message;
import com.alibaba.fastjson.JSONObject;

public interface MessageManagerService {

    public JSONObject deleteMessage(Integer messageId);

    public JSONObject insertMessages(Message message);

    public JSONObject getListMessages(String contactId);

    public JSONObject updateMessageStatus(Integer status,Integer messageId);
}
