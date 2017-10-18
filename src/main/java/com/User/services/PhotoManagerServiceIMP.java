package com.User.services;

import com.User.Dao.UserImageMapper;
import com.User.model.CollectImageBean;
import com.alibaba.fastjson.JSONObject;
import org.apache.taglibs.standard.util.EscapeXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service("photoManagerService")
public class PhotoManagerServiceIMP implements PhotoManagerService{
    
    @Autowired
    UserImageMapper mapper;
    
    @Transactional
    @Override
    public JSONObject saveImageBeans(List<String> imageList, String userId) {

        List<CollectImageBean> list = new ArrayList<CollectImageBean>();
        for (String url:imageList) {
            CollectImageBean bean = new CollectImageBean();
            bean.setUserId(userId);
            bean.setSourceUrl(url);
            list.add(bean);
        }
        try
        {
            mapper.banchCollectImageBean(list);

        }catch (Exception exption)
        {
            throw new RuntimeException(exption);
        }

        return null;
    }

    @Override
    public JSONObject getAllImagesBeans(String userId) {
        return null;
    }

    @Override
    public JSONObject deleteImageBean(String imageId) {
        return null;
    }
}
