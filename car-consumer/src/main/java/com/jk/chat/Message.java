package com.jk.chat;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ： xueqitao
 * @date ：Created in 2019/8/25 0025 11:08
 * @description：WebSocket 聊天消息类
 * @package ：com.jk.chat
 * @version: 1.0
 */
@AllArgsConstructor
@Data
public class Message {
    public static final String ENTER = "ENTER";
    public static final String SPEAK = "SPEAK";
    public static final String QUIT = "QUIT";

    public String type;//消息类型

    public String username; //发送人

    public String msg; //发送消息

    public int onlineCount; //在线用户数

    public Message(String type, String username, String msg, int onlineCount) {
        this.type = type;
        this.username = username;
        this.msg = msg;
        this.onlineCount = onlineCount;
    }

    public static String jsonStr(String type, String username, String msg, int onlineTotal) {
        return JSON.toJSONString(new Message(type, username, msg, onlineTotal));
    }
}
