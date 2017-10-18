package com.User.Controller;

import com.User.services.UploadFileService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

@Controller
@RequestMapping(value = "/upload")
public class uploadFileController
{
    @Autowired
    UploadFileService uploadFileService;
    @RequestMapping(value = "/file",method = RequestMethod.POST)
    @ResponseBody
     public JSONObject uploadFile(HttpServletRequest request, HttpServletResponse response)
     {
         JSONObject object = new JSONObject();
         CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
         if(commonsMultipartResolver.isMultipart(request))
         {
             MultipartHttpServletRequest multipartHttpServletRequest =
                     (MultipartHttpServletRequest)request;
             Iterator<String> ite = multipartHttpServletRequest.getFileNames();

             while(ite.hasNext()){
                 MultipartFile file = multipartHttpServletRequest.getFile(ite.next());
                 if(file!=null){
                     //MultipartFile multipartFile = multipartHttpServletRequest.getFile("headImage");
                    // String path = uploadFileService.saveFilePath(file);
                 }
             }
             object.put("code",200);
             object.put("msg","");
         }else {
             MultipartHttpServletRequest multipartHttpServletRequest =
                     commonsMultipartResolver.resolveMultipart(request);

         }

         return object;
     }
}
