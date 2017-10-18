package com.User.Controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @RequestMapping("/addContactByUid")
    @ResponseBody
    public JSONObject addContact(String userId)
    {
        return null;
    }

    @RequestMapping("/friendList")
    @ResponseBody
    public JSONObject getAllFriendList()
    {

        return null;
    }

    @RequestMapping("/addressBookList")
    @ResponseBody
    public JSONObject addressBookList(java.util.List phone)
    {

        return null;
    }


    @RequestMapping("/addContactMessage")
    @ResponseBody
    public JSONObject addContactMessage()
    {

        return null;
    }


    @RequestMapping("/agreeContact")
    @ResponseBody
    public JSONObject agreeContact(String userId,Boolean argess)
    {

        return null;
    }

}
