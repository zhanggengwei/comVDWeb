package com.User.Dao;

public interface ContactDao {

    public boolean banchContact();

    public boolean getContactList(String uid);

    public boolean deleteContact(String uid,String f_uid);

    public boolean updateContactNickName();




}
