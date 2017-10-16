package com.User.Controller;
import com.User.services.MessageManagerService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Message")
public class MessageManagerController {

    @Autowired
    MessageManagerService messageService;
    @RequestMapping("/sendTextMessage")
    public JSONObject sendTextMessage(String message,String contactId)
    {
        WebsocketEndPoint.sendReceiveMessage(contactId);
        return null;
    }
    @RequestMapping("/sendImageMessage")
    public JSONObject sendImageMessage()
    {
        return null;
    }
    @RequestMapping("/sendAutioMessage")
    public JSONObject sendAudioMessage()
    {
        return null;
    }
    @RequestMapping("/sendTipMessage")
    public  JSONObject sendTipMessage()
    {
        return null;
    }

}

