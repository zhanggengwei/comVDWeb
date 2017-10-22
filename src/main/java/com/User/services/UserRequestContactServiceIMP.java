package com.User.services;

import com.User.Constants.HTTPCodeConstants;
import com.User.Constants.HTTPMessageConstants;
import com.User.Dao.FriendRequestMapper;
import com.User.model.FriendRequestModel;
import com.alibaba.fastjson.JSONObject;
import org.apache.taglibs.standard.util.EscapeXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


import java.util.List;
@Service("requestContactService")
public class UserRequestContactServiceIMP implements UserRequestContactService{

    @Autowired
    FriendRequestMapper mapper;
    @Override
    public JSONObject requestModels(String userId) {
        JSONObject object = new JSONObject();
        try {
            List lists = mapper.allRquestModels(userId);
            object.put("code", HTTPCodeConstants.SUCESS_CODE);
            object.put("msg", HTTPMessageConstants.SUCESS_MESSAGE);
            object.put("result",lists);
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return object;
    }

    @Override
    public JSONObject  saveOrUpdate(FriendRequestModel model) {
        JSONObject object = new JSONObject();
        try {
            int flag = mapper.addOrUpdate(model);
            if(flag>0)
            {
                object.put("code",HTTPCodeConstants.SUCESS_CODE);
                object.put("msg",HTTPMessageConstants.SUCESS_MESSAGE);
            }else
            {
                throw  new RuntimeException(new Exception("database error"));
            }
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return object;
    }

    @Override
    public JSONObject  deleteModel(String userId, String requestId) {
        JSONObject object = new JSONObject();
        try
        {
            int flag =mapper.deleteFriendRquest(userId,requestId);
            if (flag>0)
            {
                object.put("code",HTTPCodeConstants.SUCESS_CODE);
                object.put("msg",HTTPMessageConstants.SUCESS_MESSAGE);
            }else
            {
                throw new RuntimeException(new Exception("database error"));
            }
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return object;
    }
}
