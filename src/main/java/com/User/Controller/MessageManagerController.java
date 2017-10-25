package com.User.Controller;
import com.User.model.Message;
import com.User.model.UserInfo;
import com.User.services.MessageManagerService;
import com.User.services.UploadFileService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Message")
public class MessageManagerController {

    @Autowired
    MessageManagerService messageService;
    @Autowired
    UploadFileService uploadFileService;

    @RequestMapping("/sendTextMessage")
    public JSONObject sendTextMessage(Message message)
    {
        JSONObject object = null;
        List<Message> list = new ArrayList<Message>();
        list.add(message);
        object = messageService.insertMessages(list);
        return object;
    }
    @RequestMapping(value = "/sendImageMessage",method = RequestMethod.POST)
    public JSONObject sendImageMessage(List<Message> messages)
    {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String userId = request.getParameter("userId");
        JSONObject object = new JSONObject();
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(request))
        {
            MultipartHttpServletRequest multipartHttpServletRequest =
                    (MultipartHttpServletRequest)request;
            List<String> paths =
                    uploadFileService.saveFilePath(multipartHttpServletRequest.getFiles("msg_images"),"msg_images");
            int index = 0;
            for (Message msg:messages) {
                msg.setSource_Url(paths.get(index++));
            }
            object = messageService.insertMessages(messages);

        }else {
            MultipartHttpServletRequest multipartHttpServletRequest =
                    commonsMultipartResolver.resolveMultipart(request);

        }
        return object;
    }
    @RequestMapping(value = "/sendAutioMessage",method = RequestMethod.POST)
    public JSONObject sendAudioMessage()
    {
        return null;
    }
    @RequestMapping("/sendTipMessage")
    public  JSONObject sendTipMessage(Message message)
    {
        List<Message> list = new ArrayList<Message>();
        list.add(message);
        JSONObject object = messageService.insertMessages(list);
        return object;
    }

}

