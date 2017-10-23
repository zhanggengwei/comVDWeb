package com.User.model;

import javax.websocket.Session;

public class webSocketBeans
{
    private Session session;
    private String userId;

    public Session getSession() {

        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
