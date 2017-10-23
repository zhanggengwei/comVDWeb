package com.User.Controller;
import com.User.model.UserAuth;
import com.User.model.UserInfo;
import com.User.services.UserInfoAuthService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import com.User.model.webSocketBeans;
import org.springframework.web.socket.server.standard.SpringConfigurator;

//该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。类似Servlet的注解mapping。无需在web.xml中配置。
@ServerEndpoint(value = "/websocket",configurator = SpringConfigurator.class)
public class WebsocketEndPoint {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    @Autowired
    UserInfoAuthService authService;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<webSocketBeans>
            webSocketSet = new CopyOnWriteArraySet<webSocketBeans>();

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session){

        Map<String, List<String>> map = session.getRequestParameterMap();
        String token = map.get("token").get(0);
        UserAuth auth = authService.searchAuthByToken(token);
        webSocketBeans bean = new webSocketBeans();
        bean.setUserId(auth.getUserId());
        bean.setSession(session);
        this.addSocketBeans(bean);
           //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
        System.out.println("session ---"+session.getPathParameters());
        System.out.println("session ---"+session.getRequestParameterMap());
        System.out.println("session ---"+session.getQueryString());
        System.out.println(webSocketSet);


    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
        //群发消息
        for(webSocketBeans item: webSocketSet){
            try {
                this.sendMessage(message,item.getSession());
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message,Session session) throws IOException{
        session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }

    private synchronized void addSocketBeans(webSocketBeans  bean)
    {
        webSocketBeans deleteBeans = null;
        for (webSocketBeans model:webSocketSet) {
            if(model.getUserId().equals(bean.getUserId()))
            {
                deleteBeans = model;
                break;
            }
        }
        if(deleteBeans!=null)
        {
            webSocketSet.remove(deleteBeans);
            webSocketSet.add(bean);
            this.sendLogOutMessage(bean.getSession());
        }else
        {
            webSocketSet.add(bean);
        }
    }
    private void  sendLogOutMessage(Session session)
    {
        JSONObject object = new JSONObject();
        object.put("code","3000");
        object.put("msg","new account login");

        try {
            session.getBasicRemote().sendText("帐号已经被其它用户登录");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebsocketEndPoint.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebsocketEndPoint.onlineCount--;
    }

    public static int sendReceiveMessage(String targerId)
    {
        return  0;
    }
}