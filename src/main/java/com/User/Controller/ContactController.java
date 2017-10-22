package com.User.Controller;

import com.User.model.FriendRequestModel;
import com.User.services.UserRequestContactService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/contact")
public class ContactController {


    @Autowired
    UserRequestContactService requestContactService;

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


    @RequestMapping("/contactAllRequest")
    @ResponseBody
    public JSONObject allContactRequest()
    {
        HttpServletRequest req =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).
                        getRequest();
        String userId  = (String)req.getAttribute("userId");
        JSONObject object = requestContactService.requestModels(userId);
        return object;
    }

    @RequestMapping("/sendAddContactRequest")
    @ResponseBody
    public JSONObject sendRequestAddContact(FriendRequestModel model)
    {
        HttpServletRequest req =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).
                        getRequest();
        String userId  = (String)req.getAttribute("userId");
        model.setUserId(userId);
        JSONObject object = requestContactService.saveOrUpdate(model);
        return object;
    }

}
