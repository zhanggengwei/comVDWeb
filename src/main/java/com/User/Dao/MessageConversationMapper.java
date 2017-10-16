package com.User.Dao;

import com.User.model.MessageConverstaion;

import java.util.List;

public interface MessageConversationMapper
{
    public List<MessageConverstaion> listMessages(String uid);

}
