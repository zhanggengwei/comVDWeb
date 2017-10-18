package com.User.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface PhotoManagerService {

    public JSONObject saveImageBeans(List<String> imageList,String userId);

    public JSONObject getAllImagesBeans(String userId);

    public JSONObject  deleteImageBean(String imageId);

}
