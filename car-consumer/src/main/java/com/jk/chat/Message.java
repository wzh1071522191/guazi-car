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

    private String type;//消息类型

    private String username; //发送人

    private String msg; //发送消息

    private int onlineCount; //在线用户数

    public static String jsonStr(String type, String username, String msg, int onlineTotal) {
        return JSON.toJSONString(new Message(type, username, msg, onlineTotal));
    }
}
