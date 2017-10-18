package com.User.Dao;

import com.User.model.CollectImageBean;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserImageMapper
{
    public  boolean banchCollectImageBean(List<CollectImageBean> list);

    public  boolean deleteImageBeanByImageId(Integer imageId);

    public  List<CollectImageBean> getAllCollectBeans(String userId);


}
