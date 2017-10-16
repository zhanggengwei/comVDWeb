package com.User.model;

public class MessageConverstaion
{
    private String  contactID;
    private String  unReadCount;
    private Message  lastMessage;
    private Boolean isTop;//消息置顶
    private Boolean isDistrub;//开启免打扰片
    private Boolean delete;//表示会话删除

    public String getContactID() {
        return contactID;
    }

    public void setContactID(String contactID) {
        this.contactID = contactID;
    }


    public String getUnReadCount() {
        return unReadCount;
    }

    public void setUnReadCount(String unReadCount) {
        this.unReadCount = unReadCount;
    }


    public Message getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Boolean getTop() {
        return isTop;
    }

    public void setTop(Boolean top) {
        isTop = top;
    }

    public Boolean getDistrub() {
        return isDistrub;
    }

    public void setDistrub(Boolean distrub) {
        isDistrub = distrub;
    }
}
