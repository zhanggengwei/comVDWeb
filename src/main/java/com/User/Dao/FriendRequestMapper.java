package com.User.Dao;
import java.util.List;
import com.User.model.FriendRequestModel;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRequestMapper {

    public int addOrUpdate(FriendRequestModel model);
    public int deleteFriendRquest(String userId,String requestId);
    public List<FriendRequestModel> allRquestModels(String userId);

}
