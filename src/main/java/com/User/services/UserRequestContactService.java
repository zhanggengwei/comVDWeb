package com.User.services;

import com.User.model.FriendRequestModel;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface UserRequestContactService {

    public JSONObject requestModels(String userId);

    public JSONObject saveOrUpdate(FriendRequestModel model);

    public JSONObject deleteModel(String userId,String requestId);

}
