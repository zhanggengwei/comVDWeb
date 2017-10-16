package com.User.model;

public class Message
{
    private Integer message_ID;
    private String  messageContent;
    private String  source_Url;
    private String  senderID;
    private String  receiveId;
    private Integer sendTimeInterval;
    private String  contactID;
    private Boolean deleteMessage;
    private Boolean messageRecalled;//消息的撤回
    private Integer messageStatus;//消息的状态


    public Integer getMessage_ID() {
        return message_ID;
    }

    public void setMessage_ID(Integer message_ID) {
        this.message_ID = message_ID;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getSource_Url() {
        return source_Url;
    }

    public void setSource_Url(String source_Url) {
        this.source_Url = source_Url;
    }

    public String getSendID() {
        return senderID;
    }

    public void setSendID(String sendID) {
        this.senderID = sendID;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public Integer getSendTimeInterval() {
        return sendTimeInterval;
    }

    public void setSendTimeInterval(Integer sendTimeInterval) {
        this.sendTimeInterval = sendTimeInterval;
    }

    public String getContactID() {
        return contactID;
    }

    public void setContactID(String contactID) {
        this.contactID = contactID;
    }



}
