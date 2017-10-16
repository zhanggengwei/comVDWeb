package com.User.Dao;

import com.User.model.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper
{

      public int insertMessage(Message message);

      public int deleteMessage(Integer messageId);

      public int recalledMessage(Integer messageId);

      public int updateMessageStatus(Integer status,Integer messageId);

      public List<Message> allListMessages(String contactId);
}
